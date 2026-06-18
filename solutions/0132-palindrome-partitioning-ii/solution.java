class Solution {

    private boolean isPalindrome(String s, int left, int right, int[][] pal) {

        if (left >= right)
            return true;

        if (pal[left][right] != -1)
            return pal[left][right] == 1;

        boolean ans = false;

        if (s.charAt(left) == s.charAt(right)) {
            ans = isPalindrome(s, left + 1, right - 1, pal);
        }

        pal[left][right] = ans ? 1 : 0;

        return ans;
    }

    public int minCut(String s) {

        int n = s.length();

        int[] dp = new int[n];
        int[][] pal = new int[n][n];

        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int[] row : pal)
            Arrays.fill(row, -1);

        for (int i = 0; i < n; i++) {

            // whole prefix is palindrome
            if (isPalindrome(s, 0, i, pal)) {
                dp[i] = 0;
                continue;
            }

            for (int j = 0; j < i; j++) {

                if (isPalindrome(s, j + 1, i, pal)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}
