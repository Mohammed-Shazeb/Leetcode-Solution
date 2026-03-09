class Solution {
    public String reorganizeString(String s) {
        int freqArr[] = new int[26];

        for(int i=0; i<s.length(); i++) {
            freqArr[s.charAt(i) - 'a']++;
        }

        int max = 0;
        int letter = 0;

        for(int i=0; i<freqArr.length; i++) {
            if(freqArr[i] > max) {
                max = freqArr[i];
                letter = i;
            }
        }

        if(max > (s.length()+1)/2) return "";
        char res[] = new char[s.length()];

        int idx = 0;
        while(freqArr[letter] != 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            freqArr[letter]--;
        }

        for(int i=0; i<26; i++) {
            while(freqArr[i] > 0) {

                if(idx >= s.length()) idx = 1;
                
                res[idx] = (char) (i + 'a');
                idx += 2;
                freqArr[i]--;
            }   
        }
        return new String(res);
    }
}
