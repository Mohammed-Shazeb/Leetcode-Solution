class Solution {
    static int dp[][] = new int[1001][1001];

    public String LongestCommonSubstring(String s1, String s2, int n, int m, int dp[][]) {

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = 0;
        }

        int maxLen = 0;
        int endIndex = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    int len = dp[i][j];

                    int originalStart = i - len;
                    int reversedStart = n - j;

                    // valid palindrome alignment
                    if (originalStart == reversedStart && len > maxLen) {
                        maxLen = len;
                        endIndex = i;
                    }

                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return s1.substring(endIndex - maxLen, endIndex);
    }

    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        int n = s.length();

        int dp[][] = new int[n + 1][n + 1];
        return LongestCommonSubstring(s, rev, n, n, dp);
    }
}
