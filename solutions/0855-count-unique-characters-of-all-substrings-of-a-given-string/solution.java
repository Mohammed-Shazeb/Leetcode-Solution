class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();

        int prev[] = new int[n];
        int next[] = new int[n];
        int last[] = new int[26];

        for(int i=0;i<26;i++) last[i] = -1;
        for(int i=0; i<n; i++){
            int ch = s.charAt(i) - 'A';
            prev[i] = last[ch];
            last[ch] = i;
        }

        for(int i=0;i<26;i++) last[i] = n;
        for(int i=n-1; i>=0; i--){
            int ch = s.charAt(i) - 'A';
            next[i] = last[ch];
            last[ch] = i;
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            result += (i - prev[i]) * (next[i] - i);
        }

        return result;
        
    }
}
