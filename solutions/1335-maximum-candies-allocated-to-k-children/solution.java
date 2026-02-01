class Solution {
    public int maximumCandies(int[] candies, long k) {
        long start = 1;
        long end = 0;
        for (int i = 0; i < candies.length; i++) {
            end = Math.max(end, candies[i]);
        }
        long ans = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            long val = 0;
            for (int i = 0; i < candies.length; i++) {
                val += candies[i] / mid;
            }
            if (val >= k) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int) ans;
    }
}
