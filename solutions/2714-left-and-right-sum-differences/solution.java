class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        int j=0;
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        for(int i=1;i<n;i++){
            left[i] = left[i-1] + nums[i];
            j=n-i-1;
            right[j] = right[j+1] + nums[j];
        }
        for(int i=0;i<n;i++){
            ans[i] = Math.abs(left[i] - right[i]);
        } 
            
        return ans;
        
    }
}
