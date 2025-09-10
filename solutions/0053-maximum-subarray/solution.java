class Solution {
    public static int maxSubArray(int[] nums) {
       int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            currSum = currSum + nums[i];
            if(currSum>maxSum) maxSum = currSum;
            if(currSum<0)currSum = 0;
            
        }
        return maxSum;
    }
    
}
