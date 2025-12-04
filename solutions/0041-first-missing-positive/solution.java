class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i<n){
            if(i+1 == nums[i]){
                i++;
            }else if((nums[i]-1) < n && (nums[i]-1)>-1 && nums[nums[i]-1] != nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }else {
                i++;
            }
        }
        i = 0;
        while(i<n){
            if((i+1) != nums[i]){
                return i+1;
            }
            i++;
        }
        return n+1;
    }
}
