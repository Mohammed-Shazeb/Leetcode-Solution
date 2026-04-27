class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        for (String word : wordList) {
            wordSet.add(word); 
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        visited.add(beginWord);

        int level = 1;

        while(!q.isEmpty()) {
            int n = q.size();

            while(n-- > 0) {
                String curr = q.poll();

                if (curr.equals(endWord)) return level;

                StringBuilder sb = new StringBuilder(curr);

                for (int i = 0; i < sb.length(); i++) {
                    char original = sb.charAt(i);

                    for (char ch = 'a'; ch<='z'; ch++) {
                        if (ch == original) continue;

                        sb.setCharAt(i, ch);
                        String neighbour = sb.toString();

                        if(wordSet.contains(neighbour) && !visited.contains(neighbour)) {
                            visited.add(neighbour);
                            q.add(neighbour);
                        }
                        sb.setCharAt(i, original);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
