class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;

        int n = s1.length();

        int[] freq1 = new int[26];
        for (int i = 0; i < n; i++) {
            freq1[s1.charAt(i) - 'a']++;
        }

        int[] freq2 = new int[26];
        for (int i = 0; i < n; i++) {
            freq2[s2.charAt(i) - 'a']++;
        }

        if (matches(freq1, freq2))
            return true;

        int left = 0;
        for (int right = n; right < s2.length(); right++) {
            freq2[s2.charAt(right) - 'a']++;
            freq2[s2.charAt(left) - 'a']--;
            left++;
            if (matches(freq1, freq2))
                return true;

        }

        return false;
    }
    private boolean matches(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i])
                return false;
        }
        return true;
    }
}
