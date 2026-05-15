class Solution {
    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] vis = new boolean[n];
        int totalCost = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            
            
            if (!vis[curr.v]) {

                vis[curr.v] = true;
                totalCost += curr.cost;

                for (int i = 0; i < n; i++) {
                    if (!vis[i]) {
                        int dist = Math.abs(points[curr.v][0] - points[i][0]) +
                                Math.abs(points[curr.v][1] - points[i][1]);
                        pq.add(new Pair(i, dist));
                    }
                }
            }

        }

        return totalCost;
    }
}

