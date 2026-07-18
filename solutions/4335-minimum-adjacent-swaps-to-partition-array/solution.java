class Solution {
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        long ans = 0;
        long r = 0, m = 0;
        long MOD = 1_000_000_007;
        
        for (int x : nums) {
            if (x > b) {
                r++;
            } else if (x >= a) {   // [a,b]
                ans += r;
                m++;
            } else {               // < a
                ans += r + m;
            }
        }
        
        return (int)(ans % MOD);
    }
}
