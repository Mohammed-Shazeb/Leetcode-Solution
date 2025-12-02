class Solution {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Edge> graph[] = new ArrayList[numCourses];

        // create graph
        for (int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        // add the src and dest in the graph
        for (int[] p : prerequisites) {
            int src = p[1];
            int dest = p[0];
            graph[src].add(new Edge(src, dest));
        }

        // made the in-degree arr and add the incoming node count 
        int indeg[] = new int[graph.length];
        for(int i=0; i<numCourses; i++){
            for(Edge e : graph[i]){
                indeg[e.dest]++;
            }
        }

        // make a queue and add the in-degree for each node  
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indeg.length; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }
        int res[] = new int[numCourses];
        int idx = 0;

        // remove from the queue and add in the res array and 
        // reduce the count of the in-degree count and if count of indeg is 0 add in the queue 
        while(!q.isEmpty()){
            int curr = q.remove();
            res[idx++] = curr;

            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
        // return the res arr  
        if (idx == numCourses) return res;
        // return an empty arr if the res is not true;  
        return new int[0];

    }
}
