class Solution {
    public int subsetXORSum(int[] nums) {
        int ans[] = new int[1];
        helper(nums, 0, 0, ans);
        return ans[0];
    }
    void helper(int nums[], int index, int sum, int ans[]) {
        if(index == nums.length) {
            ans[0] += sum;
            return;
        }
        helper(nums, index+1, sum^nums[index], ans);
        helper(nums, index+1, sum, ans);
    }
}
