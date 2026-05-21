class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<Integer> graph[] = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int edge[]:edges) {
            int src = edge[0];
            int dest = edge[1];

            graph[src].add(dest);
            graph[dest].add(src);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> restrict = new HashSet<>();
        for(int res:restricted) {
            restrict.add(res);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited.add(0);

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int nei:graph[curr]) {
                if(!visited.contains(nei) && !restrict.contains(nei)) {
                    q.add(nei);      
                    visited.add(nei);
                }
            }
        }

        return visited.size();
    }
}
