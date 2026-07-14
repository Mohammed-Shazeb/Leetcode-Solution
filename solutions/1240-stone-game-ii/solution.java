class Solution {
    int n;
    Integer dp[][][];
    public int solve(int piles[], int person, int i, int M) {
        // alice =1 bob =1

        if(i>=n) return 0;

        if(dp[person][i][M] != null) return dp[person][i][M];

        int result = (person == 1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int stones = 0;

        for(int x=1; x<=Math.min(2*M,n-i); x++) {
            stones += piles[i+x-1];
            if(person == 1) {       // alice
                result = Math.max(result, stones + solve(piles, 0, i+x, Math.max(M,x)));
            }
            else {       // bob
                result = Math.min(result, solve(piles, 1, i+x, Math.max(M,x)));
            }
        }
        dp[person][i][M] = result;
        return result;

    }
    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new Integer[2][101][101];

        return solve(piles, 1, 0, 1);
    }
}
