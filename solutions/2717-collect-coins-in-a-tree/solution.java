// class Solution {
//     public int collectTheCoins(int[] coins, int[][] edges) {
//         int n = coins.length;
//         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//         int indeg[] = new int[n];
        
//         for(int i = 0; i < n; i++) {
//             graph.add(new ArrayList<>());
//         }

//         for(int i = 0; i < edges.length; i++) {
//             int src = edges[i][0];
//             int dest = edges[i][1];

//             indeg[src]++;
//             indeg[dest]++;

//             graph.get(src).add(dest);
//             graph.get(dest).add(src);
//         }
//         Queue<Integer> q1 = new LinkedList<>();

//         // add all leaf nodes that have NO coins
//         for(int i = 0; i < n; i++) {
//             if(indeg[i] == 1 && coins[i] == 0) {
//                 q1.add(i);
//             }
//         }

//         // remove useless leaves
//         while(!q1.isEmpty()) {
//             int curr = q1.remove();

//             for(int nei : graph.get(curr)) {
//                 indeg[nei]--;

//                 if(indeg[nei] == 1 && coins[nei] == 0) {
//                     q1.add(nei);
//                 }
//             }
//         }
//         Queue<Integer> q = new LinkedList<>();

//         // add leaf nodes (after phase 1)
//         for(int i = 0; i < n; i++) {
//             if(indeg[i] == 1 && coins[i] == 1) {
//                 q.add(i);
//             }
//         }

//         int steps = 2;

//         while(steps-- > 0) {
//             int size = q.size();

//             for(int i = 0; i < size; i++) {
//                 int node = q.poll();
//                 indeg[node]--;

//                 for(int nei : graph.get(node)) {
//                     if(indeg[nei] > 0) {
//                         indeg[nei]--;
//                         if(indeg[nei] == 1) {
//                             q.add(nei);
//                         }
//                     }
//                 }
//             }
//         }
//         int edgesLeft = 0;
//         for(int i = 0; i < n; i++) {
//             edgesLeft += indeg[i];
//         }

//         edgesLeft /= 2;

//         return edgesLeft *= 2;
//     }
// }

class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {

        int n = coins.length;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int indeg[] = new int[n];

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e: edges){
            int u = e[0];
            int v = e[1];

            graph.get(u).add(v);
            graph.get(v).add(u);

            indeg[u]++;
            indeg[v]++;
        }

        // PHASE 1 remove leaf nodes without coins
        Queue<Integer> q1 = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indeg[i]==1 && coins[i]==0){
                q1.add(i);
            }
        }

        while(!q1.isEmpty()){
            int node = q1.poll();
            indeg[node] = 0;

            for(int nei: graph.get(node)){
                if(indeg[nei] > 0){

                    indeg[nei]--;

                    if(indeg[nei]==1 && coins[nei]==0){
                        q1.add(nei);
                    }
                }
            }
        }

        // PHASE 2 remove two layers of coin leaves
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indeg[i]==1){
                q.add(i);
            }
        }

        int steps = 2;

        while(steps-- > 0){

            int size = q.size();

            for(int i=0;i<size;i++){

                int node = q.poll();
                indeg[node] = 0;

                for(int nei: graph.get(node)){
                    if(indeg[nei] > 0){

                        indeg[nei]--;

                        if(indeg[nei]==1){
                            q.add(nei);
                        }
                    }
                }
            }
        }

        int edgesLeft = 0;

        for(int i=0;i<n;i++){
            edgesLeft += indeg[i];
        }

        edgesLeft /= 2;

        return edgesLeft * 2;
    }
}
