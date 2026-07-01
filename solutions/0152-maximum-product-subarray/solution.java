class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            int a = x;
            int b = x * max;
            int c = x * min;

            int newMax = Math.max(a, Math.max(b, c));
            int newMin = Math.min(a, Math.min(b, c));

            max = newMax;
            min = newMin;

            ans = Math.max(ans, max);
        }
        return ans;
    }
}
