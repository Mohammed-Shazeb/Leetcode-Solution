class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        long ans = 0, sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (set.contains(nums[right]) || right - left + 1 > k) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            set.add(nums[right]);

            if (right - left + 1 == k) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
