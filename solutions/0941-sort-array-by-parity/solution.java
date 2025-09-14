class Solution {
    public int[] sortArrayByParity(int[] nums) {
        // Arrays.sort(nums); //1 2 3 4 => mid si + ei-si/2  0 1 2 => mid = 1 
        int si = 0;
        int ei = nums.length - 1;
        while (si <ei) {
            if ((nums[si] & 1) == 0) si++;
            else if((nums[ei] & 1) == 1) ei--;
            else {
                int temp = nums[ei];
                nums[ei] = nums[si];
                nums[si] = temp;
                si++;
                ei--;
            }
        }
        return nums;
    }
}
