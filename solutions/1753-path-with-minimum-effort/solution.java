class Solution {
    static class Pair implements Comparable<Pair> {
        int row;
        int col;
        int dist;

        public Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;
        }
    }
    static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }};

    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        // if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
        //     return -1;
        // }
        

        int[][] difference = new int[row][col];

        for (int i = 0; i < row; i++) {
            Arrays.fill(difference[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int diff = 0;
        difference[0][0] = 0;  
        pq.add(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int r = curr.row;
            int c = curr.col;
            int currDist = curr.dist;

            if (currDist > difference[r][c]) {
                continue; 
            }
            if (r == row - 1 && c == col - 1) {
                return difference[r][c];
            }

            for (int dir[] : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col) {
                    
                    int newDiff = Math.abs(heights[nr][nc] - heights[r][c]);

                    int currDiff = difference[r][c];
                    int maxDiff = Math.max(currDiff, newDiff);

                    if(maxDiff < difference[nr][nc]) {
                        difference[nr][nc] = maxDiff;
                        pq.add(new Pair(nr, nc, maxDiff));
                    }
                        
                }
            }
        }
        return -1;
    }
}
