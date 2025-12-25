class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[n];
        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(ArrayList<Integer>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest) return true;

        visited[src] = true;
        for (int nbr : graph[src]) {
            if (!visited[nbr] && dfs(graph, nbr, dest, visited)) {
                return true;
            }
        }
        return false;
    }
}

