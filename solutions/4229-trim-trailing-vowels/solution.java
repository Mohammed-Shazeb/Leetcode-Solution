class Solution {
    public String trimTrailingVowels(String s) {
        char[] charArr = s.toCharArray();
        
        int count = 0;

        for (int i = charArr.length - 1; i >= 0; i--) {
            char c = charArr[i];

            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                break;
            }
            count++;
        }
        return s.substring(0, s.length() - count);
    }
}
