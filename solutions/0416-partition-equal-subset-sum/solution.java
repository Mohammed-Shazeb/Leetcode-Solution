class Solution {
    private boolean TargetSumSubset(int val[], int target) {
        int n = val.length;

        boolean dp[][] = new boolean[n + 1][target + 1];

        for(int i=0; i<n+1; i++) {
            dp[i][0] = true;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<target+1; j++) {
                int v = val[i-1];
                if(v<=j && dp[i-1][j-v] == true) {
                    dp[i][j] = true;
                } else if(dp[i-1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][target];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        
        if (sum % 2 != 0) return false;
        
        int target = sum / 2;
        return TargetSumSubset(nums, target);
    }
}
