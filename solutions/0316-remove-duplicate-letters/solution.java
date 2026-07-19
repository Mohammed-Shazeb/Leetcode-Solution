class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            freq[c-'a']--;
            if(visited[c-'a']) continue;

            while(!stack.isEmpty() && stack.peek()-'a' > c-'a' && freq[stack.peek()-'a']>0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
