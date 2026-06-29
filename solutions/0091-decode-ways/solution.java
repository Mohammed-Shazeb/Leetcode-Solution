class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        
        int dp[] = new int[n + 1];
        dp[0] = 1;

        int count = 0;
        for (int i = 1; i <= n; i++) {

            int singleDigit = Integer.parseInt(s.substring(i - 1, i));
            if (singleDigit >= 1 && singleDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            if (i >= 2) {
                
                int twoDigits = Integer.parseInt(s.substring(i - 2, i));
                if (twoDigits >= 10 && twoDigits <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }return dp[n];}}
