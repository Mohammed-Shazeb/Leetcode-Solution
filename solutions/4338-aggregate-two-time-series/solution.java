class Solution {
    public List<List<Integer>> aggregateTimeSeries(
            int[][] series1,
            int[][] series2) {


        List<List<Integer>> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < series1.length || j < series2.length) {

            int timestamp;

            if (j == series2.length ||
                (i < series1.length &&
                 series1[i][0] < series2[j][0])) {

                timestamp = series1[i][0];

            } else if (i == series1.length ||
                       series2[j][0] < series1[i][0]) {

                timestamp = series2[j][0];

            } else {
                timestamp = series1[i][0];
            }

            int value1 = 0;
            int value2 = 0;

            // Next available value in series1
            if (i < series1.length) {
                value1 = series1[i][1];
            }

            // Next available value in series2
            if (j < series2.length) {
                value2 = series2[j][1];
            }

            ans.add(Arrays.asList(
                    timestamp,
                    value1 + value2
            ));

            if (i < series1.length &&
                series1[i][0] == timestamp) {
                i++;
            }

            if (j < series2.length &&
                series2[j][0] == timestamp) {
                j++;
            }
        }

        return ans;
    }
}
