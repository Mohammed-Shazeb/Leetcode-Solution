class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '#';
            }
        }

        if (m == 1) {
            for (int j = 0; j < n; j++) {
                grid[0][j] = '.';
            }
        } else if (n == 1) {
            for (int i = 0; i < m; i++) {
                grid[i][0] = '.';
            }
        } else {
            for (int j = 0; j < n; j++) {
                grid[0][j] = '.';
            }

            for (int i = 0; i < m; i++) {
                grid[i][n - 1] = '.';
            }
        }

        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            ans[i] = new String(grid[i]);
        }

        return ans;
    }
}
