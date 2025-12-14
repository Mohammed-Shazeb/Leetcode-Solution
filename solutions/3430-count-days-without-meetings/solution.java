class Solution {
    public int countDays(int days, int[][] meetings) {
        if (meetings == null || meetings.length == 0) {
            return days; // no meetings, all days are free
        }
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // merge
        int totalDaysCover = 0;
        int[] curr = meetings[0];

        for (int i = 1; i < meetings.length; i++) {
            int[] next = meetings[i];
            if (curr[1] >= next[0]) {
                curr[1] = Math.max(curr[1], next[1]);
            } else {
                totalDaysCover += (curr[1] - curr[0] + 1);
                curr = next;
            }
        }
        
        totalDaysCover += (curr[1] - curr[0] + 1);

        return days - totalDaysCover;
    }
}
