class Solution {
    public int countPartitions(int nums[], int target) {
        int n = nums.length;
        int dp[][] = new int[n + 1][target + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                int v = nums[i - 1];
                if (v == 0) {
                    dp[i][j] = dp[i - 1][j] * 2;
                }
                else if (v <= j) {
                    dp[i][j] = dp[i - 1][j - v] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num:nums) sum += num;

        if (sum < Math.abs(target)) return 0;
        
        if ((sum + target) % 2 != 0) return 0;

        int newTarget = (sum + target) / 2;


        return countPartitions(nums, newTarget);
    }
}
