class Solution {

    public long maxSubarraySum(int[] nums, int k) {
        return Math.max(solve(nums, k, true), solve(nums, k, false));
    }

    private long solve(int[] nums, int k, boolean multiply) {
        long NEG = Long.MIN_VALUE / 4;

        long dp0 = NEG; // before operation
        long dp1 = NEG; // inside operation
        long dp2 = NEG; // after operation

        long ans = NEG;

        for (int x : nums) {
            long y;
            if (multiply) {
                y = 1L * x * k;
            } else {
                y = divide(x, k);
            }

            long ndp0 = Math.max(dp0 + x, (long) x);
            long ndp1 = Math.max(y,Math.max(dp0 + y, dp1 + y));
            long ndp2 = Math.max(dp2 + x,dp1 + x);

            dp0 = ndp0;
            dp1 = ndp1;
            dp2 = ndp2;

            ans = Math.max(ans, Math.max(dp1, dp2));
        }

        return ans;
    }

    // floor for positive, ceiling for negative
    private long divide(long x, int k) {
        if (x >= 0) return x / k;
        return -((-x) / k);
    }
}
