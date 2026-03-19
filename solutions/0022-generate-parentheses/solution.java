class Solution {
    private void backtrack(List<String> result, int open, int close, StringBuilder s) {
        if (open == 0 && close == 0) {
            result.add(s.toString());
            return;
        }

        if (open > 0) {
            s.append("(");
            backtrack(result, open - 1, close, s);
            s.deleteCharAt(s.length() - 1); // backtrack
        }

        if (close > open) {
            s.append(")");
            backtrack(result, open, close - 1, s);
            s.deleteCharAt(s.length() - 1); // backtrack
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, n, n, new StringBuilder());
        return result;
    }
}
