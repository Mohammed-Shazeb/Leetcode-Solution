class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count occurrences
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int count : freq.values()) {
            if (!set.add(count)) {
                return false;
            }
        }

        return true;
    }
}

