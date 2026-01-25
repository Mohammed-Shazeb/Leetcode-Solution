class Solution {
    public int minimumPrefixLength(int[] nums) {
        int count = 0;
        for(int i=nums.length-1; i>=1; i--) {
            int curr = nums[i];
            int prev = nums[i-1];
            if(prev<curr) {
                count++;
            } else {
                break;
            }
        }
        count+=1;
        return nums.length-count;
    }
}
