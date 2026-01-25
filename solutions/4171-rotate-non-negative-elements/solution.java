class Solution {
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public int[] rotateElements(int[] nums, int k) {

        int count = 0;
        for (int num : nums) if (num >= 0) count++;

        if (count == 0) return nums;

        int[] nonNeg = new int[count];
        int idx = 0;
        for (int num : nums) {
            if (num >= 0) nonNeg[idx++] = num;
        }

        k = k % nonNeg.length;
        if (k == 0) return nums;

        reverse(nonNeg, 0, k - 1);
        reverse(nonNeg, k, nonNeg.length - 1);
        reverse(nonNeg, 0, nonNeg.length - 1);

        idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                nums[i] = nonNeg[idx++];
            }
        }
        return nums;
    }
}

