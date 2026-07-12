class Solution {
    static final long MOD = 1_000_000_007;
    static final long INV2 = (MOD + 1) / 2; // modular inverse of 2

    public int minimumCost(int[] nums, int k) {
        long resources = k;
        long operations = 0;
        long cost = 0;

        for (int num : nums) {
            if (resources < num) {
                long need = (num - resources + k - 1L) / k;

                // sum of (operations+1) + ... + (operations+need), taken mod MOD
                long a = (2 * (operations % MOD) + (need % MOD) + 1) % MOD;
                long sum = (need % MOD) * a % MOD * INV2 % MOD;

                cost = (cost + sum) % MOD;
                operations += need;                 // stays well within long range
                resources += need * (long) k;        // bounded, no overflow here
            }
            resources -= num;
        }
        return (int) (cost % MOD);
    }
}
