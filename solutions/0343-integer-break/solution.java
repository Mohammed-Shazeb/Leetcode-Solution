class Solution {
    Integer dp[];
    public int ways(int n) {
        int ans = 0;

        if(n == 1) return 1;

        if (dp[n] != null) {
            return dp[n];
        }
        for(int i=1; i<n; i++) {
            int prod = i*Math.max(n-i, ways(n-i));
            ans = Math.max(ans,prod);
        }

        return dp[n] = ans;
    }

    public int integerBreak(int n) {
        dp = new Integer[n + 1];
        return ways(n);
    }
}


