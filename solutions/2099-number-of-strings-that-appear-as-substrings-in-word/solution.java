class Solution {
    public int numOfStrings(String[] patterns, String word) {
        // Set<String> set = new HashSet<>();

        int count=0;
        for (int i = 0; i < patterns.length; i++) {
            if(word.contains(patterns[i])) count++;
        }
        return count;
    }
}
