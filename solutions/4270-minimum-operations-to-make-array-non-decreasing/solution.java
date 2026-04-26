class Solution {
    public long minOperations(int[] nums) {

        long sum = 0;
    
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                long diff = (long) nums[i] - nums[i + 1];
                sum += diff;
                nums[i + 1] += diff;  // Update only the next element
            }
        }
        
        return sum;
    }
}
