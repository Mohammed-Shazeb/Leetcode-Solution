class Solution {
    static class Pair {

        int row;
        int col;
        int dist;

        public Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    static int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { 1, 1 }, { 1, -1 },
            { -1, 1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int level = 0;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        q.add(new Pair(0, 0, 1));

        // visited[0][0] = true;
        grid[0][0] = 1;

        while (!q.isEmpty()) {

            int N = q.size();

            while (N-- > 0) {

                Pair curr = q.remove();
                int r = curr.row;
                int c = curr.col;
                int currDist = curr.dist;

                if (r == n - 1 && c == n - 1) {
                    return level + 1;
                }

                for (int dir[] : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                        grid[nr][nc] = 1;
                        q.add(new Pair(nr, nc, currDist + 1));
                    }
                }
            }
            level++;
        }

        return -1;
    }
}
