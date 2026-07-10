class Solution {
    public int numSquares(int n) {
        // 43 -> 1 1,2 4,3 9,4 16,5 25, 6 36, 7 49, i+1^2 > n --> val 

        int end = (int) Math.ceil(Math.sqrt(n));
        
        if(end*end == n) return 1;

        int[] numbers = IntStream.range(1, end).toArray();

        int dp[][] = new int[numbers.length+1][n + 1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = Integer.MAX_VALUE - 1;
        }

        for (int j = 1; j < dp[0].length; j++) {
            if(j%numbers[0] == 0) {
                dp[1][j] = 1;
            } else {
                dp[1][j] = Integer.MAX_VALUE - 1;
            }
        }

        for(int i=1; i<end; i++) {
            for(int j=1; j<n+1; j++) {

                int v = numbers[i - 1] * numbers[i-1];
                if (v <= j) {
                    dp[i][j] = Math.min(dp[i][j - v] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[end-1][n];
    }
}
