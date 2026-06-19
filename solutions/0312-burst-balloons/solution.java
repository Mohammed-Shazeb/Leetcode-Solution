class Solution {
    int helper(int[] arr, int i, int j, int dp[][]) {
        if (i > j)
            return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int max = 0;

        for (int k = i; k <= j; k++) {
            int coins = helper(arr, i, k - 1, dp) + helper(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j + 1];
            max = Math.max(max, coins);
        }

        return dp[i][j] = max;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for(int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        int dp[][] = new int[301][301];
        for(int row[]:dp) {
            Arrays.fill(row, -1);
        }

        return helper(arr, 1, n, dp);
    }
}
