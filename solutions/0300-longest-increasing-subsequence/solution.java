class Solution {
    public int lcsTab(int[] nums, int[] sortedNums, int n, int m, int dp[][]) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (nums[i - 1] == sortedNums[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m]; // dp[n][m] will have the length of longest common subsequence of x and y
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];

        HashSet<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);

        int m = set.size();
        int[] sortedNums = new int[m];
        int i = 0;
        
        for(int num:set) sortedNums[i++] = num;
        
        Arrays.sort(sortedNums);

        return lcsTab(nums, sortedNums, n, m, dp); 
    }
}
