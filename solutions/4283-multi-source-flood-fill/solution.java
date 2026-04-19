class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int color[][] = new int[n][m];
        int time[][] = new int[n][m];

        for(int row[]: time) {
            Arrays.fill(row, Integer.MAX_VALUE);
        } 

        Queue<int[]> q = new LinkedList<>();

        for(int s[] : sources) {
            int r = s[0];
            int c = s[1];
            int col = s[2];

            color[r][c] = col;
            time[r][c] = 0;
            q.add(new int[]{r, c});
        }

        
        int [][] dir = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()) {
            int curr[] = q.poll();

            int r = curr[0];
            int c = curr[1];

            for(int d[]: dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                int newTime = time[r][c] + 1;

                if(time[nr][nc] > newTime) {
                    time[nr][nc] = newTime;
                    color[nr][nc] = color[r][c];
                    q.add(new int[]{nr, nc});
                } 
                else if(time[nr][nc] == newTime) {
                    color[nr][nc] = Math.max(color[nr][nc], color[r][c]);
                }
            }
        }
        return color;
    }
}
