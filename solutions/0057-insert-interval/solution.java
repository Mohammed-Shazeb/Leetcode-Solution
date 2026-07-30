class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // intervals[i][1] > newInterval[0];
        // intervals[i][1] = 

        List<int[]> list = new ArrayList<>();
        int i = 0;

        
        // Add all intervals that come completely before newInterval.
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        
        // Merge every overlapping interval.
        while (i < intervals.length && (intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1])) {

            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);

            i++;
        }

       
        // Add the merged interval.
        list.add(newInterval);

        
        // Add the remaining intervals.
        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }
}
