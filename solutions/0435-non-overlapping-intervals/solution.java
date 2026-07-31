class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int curr[] = intervals[0];
        int n = intervals.length;
        
        for(int i=1;i<n;i++) {
            int next[] = intervals[i];
            // overlap
            if(curr[1] > next[0]) {
                if(next[1]<curr[1]) curr = next; 
                count++;
            } else {
                curr = next;
            }
        }
        return count;
    }
}
