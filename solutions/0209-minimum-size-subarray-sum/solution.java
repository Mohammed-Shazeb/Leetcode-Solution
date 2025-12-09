class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }
}
