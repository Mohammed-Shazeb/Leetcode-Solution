class Solution {
    public String smallestSubsequence(String s) {

        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            freq[c - 'a']--;

            if (visited[c - 'a'])   // aready vis skip it do not add in the stack
                continue;

            while (!stack.isEmpty() && stack.peek()-'a' > c-'a' && freq[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (char c : stack)
            ans.append(c);
        return ans.toString();
    }
}
