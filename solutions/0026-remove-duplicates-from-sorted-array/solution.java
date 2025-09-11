class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;
        int count = 0;
        for (int j = 1; j < n; j++) {
            if (nums[i] < nums[j]) {
                int temp = nums[i + 1];
                nums[i + 1] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i+1;
    }
}
