class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        Set<String> visited = new HashSet<>();

        for (String word : deadends) {
            dead.add(word);
        }

        String start = "0000";
        if (dead.contains(start)) return -1;

        Queue<String> q = new LinkedList<>();
        q.add(start);

        visited.add(start);

        int level = 0;

        while (!q.isEmpty()) {
            int n = q.size();

            while (n-- > 0) {
                String curr = q.poll();

                if (curr.equals(target))
                    return level;

                StringBuilder sb = new StringBuilder(curr);

                for (int i = 0; i < 4; i++) {

                    char original = sb.charAt(i);

                    char dec = (original == '0') ? '9' : (char) (original - 1);
                    char inc = (original == '9') ? '0' : (char) (original + 1);

                    sb.setCharAt(i, dec);
                    String next = sb.toString();
                    if (!dead.contains(next) && !visited.contains(next)) {
                        visited.add(next);
                        q.add(next);
                    }

                    sb.setCharAt(i, inc);
                    next = sb.toString();
                    if (!dead.contains(next) && !visited.contains(next)) {
                        visited.add(next);
                        q.add(next);
                    }

                    sb.setCharAt(i, original);
                }
            }
            level++;
        }
        return -1;
    }
}
