class Solution {
    int n;
    int dp[][] = new int[201][1001];

    public int helper(int idx, int[] nums, int target) {

        if(target == 0) return 1;

        if(idx >=n || target<0) return 0;

        if(dp[idx][target] != -1) return dp[idx][target];
        
        int result = 0;

        for(int i=idx; i<n; i++) {
            result += helper(0, nums, target-nums[i]);
        } 

        // int take = helper(0, nums, target-nums[idx]);
        // int reject = helper(idx+1, nums, target);

        return dp[idx][target] = result; 
        
    }

    public int combinationSum4(int[] nums, int target) {
        n = nums.length;
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(0, nums, target);
    }
}
