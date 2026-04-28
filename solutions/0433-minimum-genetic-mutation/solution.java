class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        for(String s : bank) {
            bankSet.add(s);
        }
        Queue<String> q = new LinkedList<>();
        q.add(startGene);

        visited.add(startGene);

        int level = 0;

        while(!q.isEmpty()) {
            int n = q.size();

            while(n-- > 0 ) {
                String curr = q.poll();

                if(curr.equals(endGene)) return level;

                StringBuilder sb = new StringBuilder(curr);

                for(int i=0; i<sb.length(); i++) {
                    char original = sb.charAt(i);

                    for(char ch :"ACGT".toCharArray()) {
                        if(ch == original) continue;

                        sb.setCharAt(i, ch);
                        
                        String neighbour = sb.toString();

                        if(bankSet.contains(neighbour) && !visited.contains(neighbour)) {
                            visited.add(neighbour);
                            q.add(neighbour);
                        }
                    }
                    sb.setCharAt(i, original);
                }
            }
            level++;
        }
        return -1;
    }
}
