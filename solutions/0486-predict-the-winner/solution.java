class Solution {
    // int[][] dp;
    // public int solve(int[] arr, int left, int right) {

    //     if (left > right) return 0;

    //     if (dp[left][right] != -1) return dp[left][right];

    //     if (arr[left] == arr[right])
    //         return dp[left][right] = arr[left];

        
    //     int takeFirst = arr[left] + Math.min(solve(arr, left + 2, right), solve(arr, left + 1, right-1));
    //     int takeLast = arr[right] + Math.min(solve(arr, left , right-2), solve(arr, left + 1, right-1));

    //     return dp[left][right] = Math.max(takeFirst, takeLast);
    // }

    int[][] dp;
    int n;

    private int solve(int[] nums, int l, int r) {
        if (l > r)
            return 0;

        if (l == r)
            return nums[l];

        if (dp[l][r] != -1)
            return dp[l][r];

        int takeLeft = nums[l] + Math.min(solve(nums, l + 2, r),
                                          solve(nums, l + 1, r - 1));

        int takeRight = nums[r] + Math.min(solve(nums, l, r - 2),
                                           solve(nums, l + 1, r - 1));

        return dp[l][r] = Math.max(takeLeft, takeRight);
    }    
    public boolean predictTheWinner(int[] nums) {
        // int n = nums.length;
        // dp = new int[n][n];
        // for (int[] row : dp) Arrays.fill(row, -1);

        // int total = 0;
        // for (int x : nums) total += x;

        // int p1 = solve(nums, 0, n - 1);
        // int p2 = total-p1;
        // return p1 >= p2;
        n = nums.length;
        dp = new int[23][23];

        for (int i = 0; i < 23; i++) {
            Arrays.fill(dp[i], -1);
        }

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int player1 = solve(nums, 0, n - 1);
        int player2 = total - player1;

        return player1 >= player2;
    }
}

