class Solution {
    Map<String, List<String>> memo;

    public List<String> wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        return helper(s, new HashSet<>(wordDict));
    }

    private List<String> helper(String s, Set<String> dict) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> res = new ArrayList<>();
        if (dict.contains(s)) res.add(s);

        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            if (!dict.contains(left)) continue;
            String right = s.substring(i);
            for (String sub : helper(right, dict)) {
                res.add(left + " " + sub);
            }
        }

        memo.put(s, res);
        return res;
    }
    
}


