class Solution {
    List<Integer>[] tree;
    int[] baseTime;

    public long finishTime(int n, int[][] edges, int[] baseTime) {
        this.baseTime = baseTime;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            tree[parent].add(child);
        }

        return dfs(0);
    }

    private long dfs(int node) {

        // leaf node
        if (tree[node].isEmpty()) {
            return baseTime[node];
        }

        long minChild = Long.MAX_VALUE;
        long maxChild = Long.MIN_VALUE;

        for (int child : tree[node]) {
            long childFinish = dfs(child);

            minChild = Math.min(minChild, childFinish);
            maxChild = Math.max(maxChild, childFinish);
        }

        return (2 * maxChild) - minChild + baseTime[node];
    }
}
