class Solution {
    int ans = 0;
    public int subsetXORSum(int[] nums) {
        helper(nums, 0, 0);
        return ans;
    }

    void helper(int nums[], int index, int sum) {
        if (index == nums.length) {
            ans += sum;
            return;
        }
        helper(nums, index + 1, sum ^ nums[index]);
        helper(nums, index + 1, sum);
    }
}
