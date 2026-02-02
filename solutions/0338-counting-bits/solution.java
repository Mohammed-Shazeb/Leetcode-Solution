class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n+1];      
        int idx = 0;      
        for(int i=0; i<=n; i++) {
            res[idx++] = countOne(i);
        }
        return res;
    }
    private int countOne(int n) {
        int count = 0;

        while(n!=0) {
            if((n&1) == 1) count++;
            n = n>>1;
        }
        return count;
    }
}
