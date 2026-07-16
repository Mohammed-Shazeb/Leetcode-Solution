class Solution {
    public int helper(int val[]) {
        int sum = 0;
        for (int i = 0; i < val.length; i++) {
            sum += val[i];
        }

        int n = val.length;

        boolean dp[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int v = val[i - 1];
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }

            }
        }
        List<Integer> res = new ArrayList<>();

        for (int j = 0; j < sum + 1; j++) {
            if (dp[n][j] == true) {
                res.add(j);
            }
        }

        int minDiff = Integer.MAX_VALUE;

        for (int s1 : res) {
            minDiff = Math.min(minDiff, Math.abs(sum - 2 * s1));
        }

        return minDiff;
    }

    public int lastStoneWeightII(int[] stones) {
        return helper(stones);
    }
}
