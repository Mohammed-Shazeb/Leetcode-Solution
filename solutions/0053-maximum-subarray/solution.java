class Solution {
    public static int maxSubArray(int[] nums) {
       int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            currSum = currSum + nums[i];
            if(currSum>maxSum){
                maxSum = currSum;
            }
            if(currSum<0){
                currSum = 0;
            }
        }
        System.out.println("maxSum: "+ maxSum);
        return maxSum;
    }
    public static void main(String[] args){
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.println("result: "+ result);
    }
}
