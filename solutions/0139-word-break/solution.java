class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length() + 1];
       return helper(0, s, dict, dp);
    }

    private boolean helper(int start, String s, Set<String> dict, Boolean[] dp) {
        
        if (start == s.length()) return true;

        // Memo check
        if (dp[start] != null) return dp[start];

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);

            if (dict.contains(word) && helper(end, s, dict, dp)) {
                dp[start] = true;
                return true;
            }
        }

        dp[start] = false;
        return false;
    
    }
}
