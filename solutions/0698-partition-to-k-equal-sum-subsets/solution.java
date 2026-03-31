class Solution {
    private boolean backtrack(int nums[], boolean used[], int k, int start, int currSum, int target) {
        if (k == 1)
            return true;

        if (currSum == target) {
            return backtrack(nums, used, k - 1, 0, 0, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i] || currSum + nums[i] > target) continue;

            used[i] = true;
           
            if (backtrack(nums, used, k, i + 1, currSum + nums[i], target)) {
                return true;
            }
            used[i] = false;
        }
        return false;

    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        if (sum % k != 0)
            return false;

        int target = sum / k;
        boolean[] used = new boolean[nums.length];

        return backtrack(nums, used, k, 0, 0, target);
    }
}
