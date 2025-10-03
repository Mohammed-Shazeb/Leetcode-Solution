class Solution {
    public boolean canAliceWin(int[] nums) {
        int n = nums.length;
        int singleDigitSum = 0;
        int doubleDigitSum = 0;
        for(int i=0;i<n;i++){
            if(nums[i] <= 9) singleDigitSum += nums[i];
            else doubleDigitSum += nums[i];
        }
        return singleDigitSum != doubleDigitSum;
    }
}
