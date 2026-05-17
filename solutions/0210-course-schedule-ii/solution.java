class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];

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
        int res[] = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()){
            int curr = q.remove();
            res[idx++] = curr;
            
            for(int neighbour : graph[curr]){
                indeg[neighbour]--;
                if(indeg[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        if (idx == numCourses) return res;
        return new int[0];
    

    }
}
