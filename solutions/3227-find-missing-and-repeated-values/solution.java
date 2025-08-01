class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int count[] = new int[n * n + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                count[grid[i][j]]++;
            }
            System.out.println();
        }
        int a[] = new int[2];
        for (int i = 0; i < n * n + 1; i++) {
            if (count[i] == 2) {
                a[0] = i;
            }
            if (count[i] == 0) {
                a[1] = i;
            }
        }
        return a;
    }
}
