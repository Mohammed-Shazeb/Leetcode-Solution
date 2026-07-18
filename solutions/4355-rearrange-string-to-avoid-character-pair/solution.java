class Solution {
    public String rearrangeString(String s, char x, char y) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        while (freq[y - 'a']-- > 0) {
            ans.append(y);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (c == x || c == y) continue;

            while (freq[c - 'a']-- > 0) {
                ans.append(c);
            }
        }

        while (freq[x - 'a']-- > 0) {
            ans.append(x);
        }

        return ans.toString();
    }
}
