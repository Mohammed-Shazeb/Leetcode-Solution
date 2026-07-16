class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0 || n==1) return 0;
        int dp[] = new int[n];
        
        dp[0] = 0;
        dp[1] = Math.max(prices[1]-prices[0], 0);


        for(int i=2;i<n;i++) {
            dp[i] = dp[i-1];
            for(int j=0;j<i;j++) {
                int prevProfit = (j>=2) ? dp[j-2] : 0;
                dp[i] = Math.max(dp[i], prices[i]-prices[j] + prevProfit);
            }
        }
        return dp[prices.length-1];
    }
}
