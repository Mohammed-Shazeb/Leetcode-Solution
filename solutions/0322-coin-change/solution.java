class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1); // acts like infinity
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
