class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        if (n == 3)
            return nums[0] * nums[1] * nums[2];
        Arrays.sort(nums);
        if(nums[0] > 0) {
            return nums[n-1] * nums[n-2] * nums[n-3];
        }

        
        int last3 = nums[n-1] * nums[n-2] * nums[n-3];
        int first3 = nums[0] * nums[1] * nums[2];
        int firstOneLastTwo = nums[0] * nums[n-1] * nums[n-2];
        int firstTwo = nums[0] * nums[1] * nums[n-1];

        int firstMax = Math.max(first3, last3);
        int lastTwo = Math.max(firstOneLastTwo, firstTwo);
        return Math.max(firstMax, lastTwo);
    }
}
