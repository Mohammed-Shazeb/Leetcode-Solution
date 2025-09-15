class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n + n];
        for (int i = 0, j = n; i < n && j < ans.length; i++, j++) {
            ans[i] = nums[i];
            ans[j] = nums[i];
        }
        return ans;
    }
}
