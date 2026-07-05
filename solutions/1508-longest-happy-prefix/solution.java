class Solution {
    public int[] computeLPS(String s) {
        int m = s.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;

    }
    public String longestPrefix(String s) {
        int n = s.length();
        int lps[] = computeLPS(s);
        return s.substring(0, lps[s.length() - 1]);
    }
}
