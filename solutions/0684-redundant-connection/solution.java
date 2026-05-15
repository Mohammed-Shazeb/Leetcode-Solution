class Solution {
    int parent[] = new int[1001];
    int rank[] = new int[1001];

    public void initialize() {
        for (int i = 1; i < 1001; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]) {
            parent[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA] > rank[parB]) {
            parent[parB] = parA;
        }
        else {
            parent[parA] = parB;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        initialize();

        int src = 0;
        int dest = 0;

        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            int parA = find(u);
            int parB = find(v);

            if (parA == parB) {
                src = u;
                dest = v;   
            } else {
                union(u, v);
            }
        }

        return new int[]{src, dest};
    }
}
