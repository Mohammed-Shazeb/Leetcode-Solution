class Solution {
    static class State {
        int node;
        int runLength;
        long cost;

        State(int node, int runLength, long cost) {
            this.node = node;
            this.runLength = runLength;
            this.cost = cost;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            graph[u].add(new int[] { v, w });

        }
        long INF = Long.MAX_VALUE / 4;

        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));

        dist[0][1] = 0;

        pq.offer(new State(0, 1, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            int node = cur.node;
            int run = cur.runLength;
            long cost = cur.cost;

            if (cost != dist[node][run]) {
                continue;
            }

            if (node == n - 1) {
                return (int)cost;
            }

            for(int edge[] : graph[node]) {
                int child = edge[0];
                int weight = edge[1];

                int nextRun;
                
                if(labels.charAt(child) == labels.charAt(node)) {
                    nextRun = run+1;
                } else {
                    nextRun = 1; 
                }
                if(nextRun>k) continue;

                if(cost+weight < dist[child][nextRun]) {
                    dist[child][nextRun] = cost+weight;

                    pq.offer(new State(child, nextRun, cost+weight));
                }
            }
        }
        return -1;
    }
}
