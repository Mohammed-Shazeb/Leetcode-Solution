class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int[] freq = new int[26];
        int maxLen = 0;
        int maxFreq = 0;

        for(int end=0; end<s.length(); end++) {
            int idx = s.charAt(end) - 'A';
            freq[idx]++;

            maxFreq = Math.max(maxFreq, freq[idx]);

            int windowSize = end-start+1;

            int changes_needed_to_be_req = windowSize - maxFreq;

            if(changes_needed_to_be_req > k) {
                freq[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);

        }
        return maxLen;    
    }
}
