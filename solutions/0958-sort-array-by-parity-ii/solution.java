class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int evenIdx = 0;
        int oddIdx = 1;
        int n = nums.length;
        
        while (evenIdx < n && oddIdx < n) {
            if ((nums[evenIdx] & 1) == 0) evenIdx += 2;
            else if ((nums[oddIdx] & 1) == 1) oddIdx += 2;
           else {
                int temp = nums[evenIdx];
                nums[evenIdx] = nums[oddIdx];
                nums[oddIdx] = temp;
                evenIdx += 2;
                oddIdx += 2;
            }
        }
        return nums;
    }
}

