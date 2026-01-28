class Solution {
    // We scan the string left to right and remove invalid ) by only keeping them when there’s a matching (.
    // Then we scan the result right to left to remove extra ( that don’t have a closing ).
    // This keeps only the minimum parentheses needed to make the string valid.
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder("");
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                sb.append(curr);
                open++;
            } else if (curr == ')') {
                if (open > 0) {
                    open--;
                    sb.append(curr);
                } else {
                    continue;
                }
            } else {
                sb.append(curr);
            }
        }
        StringBuilder res = new StringBuilder("");
        for (int i = sb.length() - 1; i >= 0; i--) {
            char curr = sb.charAt(i);
            if (curr == '(' && open > 0) {
                open--; // skip extra '('
                continue;
            }
            res.append(curr);
        }
        return res.reverse().toString();
    }
}
