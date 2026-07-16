class Solution {
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long gcdSum(int[] nums) {
        
        int n = nums.length;
        int prefixGcd[] = new int[n];

        int mx = nums[0];

        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            prefixGcd[i] = gcd(nums[i], mx);
        }

        
        Arrays.sort(prefixGcd);

        int first = 0;
        int last = n - 1;
        long sum = 0;

        while (first < last) {
            sum += gcd(prefixGcd[first], prefixGcd[last]);
            first++;
            last--;
        }

        return sum;

    }
}
