class Solution {
    public int jump(int[] nums) {
        // int n = nums.length;

        // int dp[] = new int[n];
        // Arrays.fill(dp, -1);
        // dp[n - 1] = 0;

        // for (int i = n - 2; i >= 0; i--) {
        //     int steps = nums[i];
        //     int ans = Integer.MAX_VALUE;
        //     for (int j = i + 1; j <= i + steps && j < n; j++) {
        //         if (dp[j] != -1) {
        //             ans = Math.min(ans, dp[j] + 1);
        //         }
        //     }
        //     if (ans != Integer.MAX_VALUE)
        //         dp[i] = ans;
        // }
        // return dp[0];

        int res = 0;
        int l=0,r=0;

        while(r<nums.length-1) {
            int farthest = 0;
            for(int i=l;i<=r;i++) {
                farthest = Math.max(farthest, i+nums[i]);
            }
            l = r+1;
            r = farthest;
            res +=1;
        }
        return res;
    }
}
