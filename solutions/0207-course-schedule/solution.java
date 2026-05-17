class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];

        // create graph
        for (int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        int indeg[] = new int[graph.length];

        for (int[] p : prerequisites) {
            int src = p[1];
            int dest = p[0];
            graph[src].add(dest);
            indeg[dest]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indeg.length; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }
        
        int idx = 0;

        while(!q.isEmpty()){
            int curr = q.remove();
            idx++;
            
            // for(int i=0;i<graph[curr].size();i++){
            //     int e = graph[curr].get(i);
            //     indeg[e]--;
            //     if(indeg[e] == 0){
            //         q.add(e);
            //     }
            // }
            for(int neighbour : graph[curr]){
                indeg[neighbour]--;
                if(indeg[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        if (idx == numCourses) return true;
        return false;
    }
}
