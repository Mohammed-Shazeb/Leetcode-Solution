class Solution {
    private int helper(int start, String s, Set<String> dict, int[] dp) {
        if (start == s.length()) return 0;

        

        if (dp[start] != -1) return dp[start];

        int ans = Integer.MAX_VALUE;

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);

            int count = (dict.contains(word) ? 0 : word.length()) + helper(end, s, dict, dp);

            ans = Math.min(ans, count);
        }
        
        dp[start] = ans;
        return ans;
    }

    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return helper(0, s, dict, dp);
    }
}
