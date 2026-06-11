class Solution {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph, int[][] times) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int edge[] : times) {
            int src = edge[0];
            int dest = edge[1];
            int wt = edge[2];

            graph[src].add(new Edge(src, dest, wt));
        }
    }

    static class Pair implements Comparable<Pair> {
        int n; //The current node number
        int path; //The shortest distance discovered so far from source to node n

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public int dijkstra(int[][] times, int n, int k, ArrayList<Edge>[] graph, int dist[]) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (curr.path > dist[curr.n]) {
                continue;
            }

            for (int i = 0; i < graph[curr.n].size(); i++) {
                Edge e = graph[curr.n].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }            

        int res = 0;
        for (int i = 1; i < dist.length; i++) {
            res = Math.max(res, dist[i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        createGraph(graph, times);

        return dijkstra(times, n, k, graph, dist);
    }
}
