// class Solution {
//     public static void swap(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         // grid[i][j] moves to grid[i][j + 1].
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n - 1; j++) {
//                 int temp = grid[i][j];
//                 grid[i][j] = grid[i][j + 1];
//                 grid[i][j + 1] = temp;
//             }
//         }
//         // grid[i][n - 1] moves to grid[i + 1][0].
//         for (int i = 0; i < m - 1; i++) {
//             for (int j = 0; j < n - 1; j++) {
//                 int temp = grid[i][n - 1];
//                 grid[i][n - 1] = grid[i + 1][0];
//                 grid[i + 1][0] = temp;
//             }
//         }
//         // grid[m - 1][n - 1] moves to grid[0][0].
//         // for (int i = 0; i < m; i++) {
//         //     for (int j = 0; j < n - 1; j++) {
//         //         int temp = grid[m-1][n-1];
//         //         grid[m-1][n-1] = grid[0][0];
//         //         grid[0][0] = temp;
//         //     }
//         // }
//         int last = grid[m - 1][n - 1];

//         for (int i = m - 1; i >= 0; i--) {
//             for (int j = n - 1; j >= 0; j--) {
//                 if (i == 0 && j == 0) {
//                     grid[0][0] = last;
//                 } else if (j == 0) {
//                     grid[i][0] = grid[i - 1][n - 1];
//                 } else {
//                     grid[i][j] = grid[i][j - 1];
//                 }
//             }
//         }
//     }

//     public List<List<Integer>> shiftGrid(int[][] grid, int k) {
//         List<List<Integer>> list = new ArrayList<>();

//         for (int[] row : grid) {
//             List<Integer> temp = new ArrayList<>();
//             for (int x : row) {
//                 temp.add(x);
//             }
//             list.add(temp);
//         }
//         return list;
//     }
// }

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k %= total;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;          // current 1D index
                int newIdx = (idx + k) % total; // shifted index

                ans[newIdx / n][newIdx % n] = grid[i][j];
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int[] row : ans) {
            List<Integer> list = new ArrayList<>();
            for (int x : row) {
                list.add(x);
            }
            res.add(list);
        }

        return res;
    }
}
