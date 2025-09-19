class Solution {
    public int subarraySum(int[] nums, int k) {
        // int sum = 0;
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j]; // build the subarray
                if (sum == k)
                    count++;
            }
        }

        return count;
    }
}
