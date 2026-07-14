class Solution {
    int n;
    Integer dp[][];
    public int solve(int stoneValue[], int person, int i) {
        // alice =1 bob =1

        if(i>=n) return 0;

        if(dp[person][i] != null) return dp[person][i];

        int result = (person == 1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int stones = 0;

        for(int x=1; x<=3 && i+x<=n; x++) {
            stones += stoneValue[i+x-1];
            if(person == 1) {       // alice
                result = Math.max(result, stones + solve(stoneValue, 0, i+x));
            }
            else {       // bob
                result = Math.min(result, solve(stoneValue, 1, i+x));
            }
        }
        dp[person][i] = result;
        return result;

    }
    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        dp = new Integer[2][50001];
        int totalScore = 0;

        for(int num:stoneValue) totalScore += num;
        int aliceScore = solve(stoneValue, 1, 0);
        
        int diff = 2*aliceScore - totalScore;

        if(diff >0) return "Alice";
        else if(diff == 0) return "Tie";
        return "Bob"; 

    }
}
