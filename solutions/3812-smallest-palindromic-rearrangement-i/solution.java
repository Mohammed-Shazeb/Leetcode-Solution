class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        // if(n<4) return s;
        int freq[] = new int[26];

        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            // if (freq[c - 'a'] == 0) {
            // }
        }
        int mid = 0;
        for(int i=0;i<26;i++) {
            if(freq[i]%2!=0) mid = i;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for(int j=1;j<=freq[i]/2;j++) {
                sb.append((char)(i + 'a'));
            }
            // freq[i]--;
            
        }
        StringBuilder rev = new StringBuilder(sb).reverse();

        // odd len
        if(n%2!=0) {
            return sb.toString() + (char)(mid+'a') + rev.toString();
        }
        return sb.toString() + rev.toString();


        // if(n%2!=0) {
        //     sb.append(sb.charAt(sb.length()-1));
        //     int len = sb.length();
        //     for (int i = len - 2; i >= 0; i--) {
        //         sb.append(sb.charAt(i));
        //     }
        //     return sb.toString();
        // }   
        // sb.append(new StringBuilder(sb).reverse());

        // return sb.toString();
    }
}
