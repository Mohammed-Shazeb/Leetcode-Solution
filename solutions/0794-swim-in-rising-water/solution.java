class Solution {
    static class Pair implements Comparable<Pair> {
        int row;
        int col;
        int dist;

        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;
        }
    }

    static int directions[][] = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

    public int swimInWater(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;


        int[][] minWaterLevel = new int[row][col];

        for (int i = 0; i < row; i++) {
            Arrays.fill(minWaterLevel[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int diff = 0;
        minWaterLevel[0][0] = grid[0][0];  
        pq.add(new Pair(0, 0, minWaterLevel[0][0]));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int r = curr.row;
            int c = curr.col;
            int currDist =curr.dist;

            if(currDist> minWaterLevel[r][c]) {
                continue;
            }
            if (r == row - 1 && c == col - 1) { 
                return minWaterLevel[r][c];
            }

            for(int dir[]: directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr>=0 && nr<row && nc>=0 && nc<col) {
                    int minTime = minWaterLevel[r][c];
                    int maxValue = Math.max(minTime, grid[nr][nc]);

                    if(maxValue< minWaterLevel[nr][nc]) {
                        minWaterLevel[nr][nc] = maxValue;
                        pq.add(new Pair(nr, nc, maxValue));
                    } 
                }

            }
        }
        return -1;

    }
}
