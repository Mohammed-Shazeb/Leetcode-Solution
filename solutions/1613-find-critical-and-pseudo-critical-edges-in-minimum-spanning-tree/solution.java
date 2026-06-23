class Solution {
    //kruskal
    public int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x], parent);
    }

    public void union(int a, int b, int[] parent, int[] rank) {

        int parA = find(a, parent);
        int parB = find(b, parent);

        if (parA == parB) {
            return;
        }

        if (rank[parA] < rank[parB]) {
            parent[parA] = parB;
        } else if (rank[parA] > rank[parB]) {
            parent[parB] = parA;
        } else {
            parent[parB] = parA;
            rank[parA]++;
        }
    }

    public int kruskal(int n, int[][] edges, int skipEdge, int forceEdge) {

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int cost = 0;
        int edgesUsed = 0;

        // Force include an edge first
        if (forceEdge != -1) {

            int u = edges[forceEdge][0];
            int v = edges[forceEdge][1];
            int wt = edges[forceEdge][2];

            union(u, v, parent, rank);

            cost += wt;
            edgesUsed++;
        }

        for (int i = 0; i < edges.length; i++) {

            if (i == skipEdge) {
                continue;
            }

            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            if (find(u, parent) != find(v, parent)) {

                union(u, v, parent, rank);

                cost += wt;
                edgesUsed++;
            }
        }

        return edgesUsed == n - 1 ? cost : Integer.MAX_VALUE;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // kruskal

        int m = edges.length;

        // src, dest, weight, originalIndex
        int[][] newEdges = new int[m][4];

        for (int i = 0; i < m; i++) {
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i;
        }

        Arrays.sort(newEdges, (a, b) -> a[2] - b[2]);

        for (int[] edge : newEdges) {
            System.out.println(edge[0] + " " + edge[1] + " " + edge[2] + " " + edge[3]);
        }
        int mstWeight = kruskal(n, newEdges, -1, -1);
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int i = 0; i < newEdges.length; i++) {

            int withoutEdge = kruskal(n, newEdges, i, -1);
            if (withoutEdge > mstWeight) {
                critical.add(newEdges[i][3]);
            }

            else {
                int withEdge = kruskal(n, newEdges, -1, i);
                if (withEdge == mstWeight) {
                    pseudo.add(newEdges[i][3]);
                }

            }

        }
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(critical);
        ans.add(pseudo);

        return ans;
    }
}
