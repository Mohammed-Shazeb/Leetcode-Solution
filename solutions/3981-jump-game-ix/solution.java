class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] leftMax = new int[n];
        int[] rightMin = new int[n];

        leftMax[0] = nums[0];
        rightMin[n-1] = nums[n-1];
 
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
            rightMin[n - i - 1] = Math.min(rightMin[n - i], nums[n - i - 1]);
        }

        int ans[] = new int[n];
        ans[n - 1] = leftMax[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (leftMax[i] > rightMin[i + 1]) {
                ans[i] = ans[i + 1];
            } else {
                ans[i] = leftMax[i];
            }
        }
        return ans;
    }
}
