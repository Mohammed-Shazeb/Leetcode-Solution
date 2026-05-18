class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int indeg[] = new int[n];
        
        
        if(n == 1) {
            return Arrays.asList(0);
        }

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];

            indeg[src]++;
            indeg[dest]++;

            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            if(indeg[i] == 1) q.add(i);
        }

        while(n > 2) {
            int size = q.size();

            n -= size;

            for(int i=0; i<size; i++) {
                int curr = q.remove();

                for(int nei:graph.get(curr)) {
                    indeg[nei]--;
                    if (indeg[nei] == 1) {
                        q.add(nei);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            res.add(q.remove());
        }
        return res;
    }
}

