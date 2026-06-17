class Solution {
    public long maxRatings(int[][] units) {
        long sumSecond = 0;
        int minFirst = Integer.MAX_VALUE;
        int minSecond = Integer.MAX_VALUE;

        for (int[] row : units) {
            Arrays.sort(row);

            minFirst = Math.min(minFirst, row[0]);

            if (row.length == 1) {
                sumSecond += row[0];
                continue;  // cant do break cause there can multiple rows whose length is only one 
            }

            minSecond = Math.min(minSecond, row[1]);
            sumSecond += row[1];
        }

        if (minSecond == Integer.MAX_VALUE) {
            return sumSecond;
        }

        return sumSecond - minSecond + minFirst;

    }
}
