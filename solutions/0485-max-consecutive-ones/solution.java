class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int tracker = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                count++;
                tracker = Math.max(count,tracker);
            }else{
                count = 0;
            }
        }
        return tracker;
    }
}
