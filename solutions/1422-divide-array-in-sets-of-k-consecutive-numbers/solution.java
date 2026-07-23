class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n % k != 0)
            return false;
        
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int remaining = n;
        int i =0;

        while (remaining > 0) {
            
             while (freq.get(nums[i]) == 0) {
                i++;
            }

            int start = nums[i];

            for (int x = start; x < start + k; x++) {
                if (!freq.containsKey(x) || freq.get(x) == 0) {
                    return false;
                }
                freq.put(x, freq.get(x) - 1);
            }
            remaining -= k;
        }
        return true;
    }
}
