class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long start = 0;
        long end = -1;    
        for(int i=0; i<piles.length; i++) {
            end = Math.max(end, piles[i]);
        }
        long ans = -1;

        while(start<=end) {
            long mid = start + (end-start)/2;
            int val = 0;
            for(int i=0; i<piles.length; i++) {
                val += Math.ceil((double)piles[i]/mid);
            }
            if(val > h) {
                start = mid+1;
            }else {
                ans = mid;
                end = mid-1;
            }
        }
        return (int)ans;
    }
}
