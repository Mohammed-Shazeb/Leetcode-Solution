class Solution {
    public long repairCars(int[] ranks, int cars) {
        long start = 1;
        long end = 0;    
        for(int i=0; i<ranks.length; i++) {
            end = Math.max(end, ranks[i]);
        }
        end *= (long) cars * cars;

        long ans = 0;

        while(start<=end) {
            long mid = start + (end-start)/2;
            long val = 0;
            for(int i=0; i<ranks.length; i++) {
                val += Math.sqrt(mid/ranks[i]);
            }
            if(val >= cars) {
                ans = mid;
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return ans;
    }
}
