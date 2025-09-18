class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }
        int slow1 = 0;
        while(true){
            slow = nums[slow];
            slow1 = nums[slow1];
            if(slow == slow1){
                break;
            }
        }

        return slow;
    }

}
