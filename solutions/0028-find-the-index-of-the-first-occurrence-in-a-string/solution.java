class Solution {
    public int[] computeLPS(String needle) {
        int m = needle.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (needle.charAt(i) == needle.charAt(len)) {
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

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        int lps[] = computeLPS(needle);

        int i = 0;
        int j = 0;

        while (i < n) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == m)
                return i - j;
            else if (i < n && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return -1;
    }
}
