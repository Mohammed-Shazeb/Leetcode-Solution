class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int[] freq = new int[26];
        int maxLen = 0;
        int maxVal = 0;

        for (int end = 0; end < s.length(); end++) {
            int idx = s.charAt(end) - 'A';
            freq[idx]++;

            maxVal = Math.max(maxVal, freq[idx]);

            int windowSize = end - start + 1;

            if (windowSize - maxVal > k) {
                // Shrink the window from the left
                freq[s.charAt(start) - 'A']--;
                start++;
            }
            // Update maxLen after adjusting window
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
