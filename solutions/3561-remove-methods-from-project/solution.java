class Solution {
    static void dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] notSus) {
        visited[node] = true;
        notSus[node] = false;

        // Check every edge
        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs(nei, graph, visited, notSus);
            }
        }

        // for (int[] edge : edges) {
        //     if (edge[0] == node && !visited[edge[1]]) {
        //         dfs(edge[1], edges, visited, notSus);
        //     }
        // }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // for(int i=0;i<graph.size())
        for (int[] edge : invocations) {
            graph.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[n];
        boolean[] notSus = new boolean[n];
        Arrays.fill(notSus, true);

        dfs(k, graph, visited, notSus);
        // for(boolean n : notSus) {
        //     if(n == )
        // }

        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (notSus[u] && !notSus[v]) {
                // Impossible to remove suspicious methods
                // Return all methods
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    ans.add(i);
                return ans;
            }
        }
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (notSus[i])
                ans.add(i);
        }

        return ans;
    }
}
