class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int first = 0, second = 0;

        while (first < word1.length() && second < word2.length()) {
            sb.append(word1.charAt(first++));
            sb.append(word2.charAt(second++));
        }

        while (first < word1.length()) {
            sb.append(word1.charAt(first++));
        }

        while (second < word2.length()) {
            sb.append(word2.charAt(second++));
        }

        return sb.toString();
    }
}

