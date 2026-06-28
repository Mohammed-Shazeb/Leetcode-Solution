class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);

        long total = 0;
        int n = nums.length;

        for (int i = 0; i < k; i++) {
            long val = nums[n - 1 - i];   // largest first
            long m   = mul - i;            // highest multiplier first
            total += Math.max(val, m * val);
        }

        return total;
        
    }
}
