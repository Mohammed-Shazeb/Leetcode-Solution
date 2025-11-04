import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Count frequency of each number
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Get unique keys (numbers) into a list
        List<Integer> list = new ArrayList<>(map.keySet());

        // Step 3: Sort list by frequency descending, then value ascending
        Collections.sort(list, (a, b) -> {
            if (map.get(b) == map.get(a)) {
                return b - a; 
            }
            return map.get(a) - map.get(b);
        });

        // Step 4: Build the result array by repeating numbers according to frequency
        int[] result = new int[nums.length];
        int index = 0;
        for (int num : list) {
            int freq = map.get(num);
            for (int i = 0; i < freq; i++) {
                result[index++] = num;
            }
        }
        return result;
    }
}

