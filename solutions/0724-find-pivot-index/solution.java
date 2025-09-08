class Solution {
    public int pivotIndex(int[] nums) {
        int[] leftPreSum = new int[nums.length];
        int[] rightPreSum = new int[nums.length];
        int n = nums.length;

        leftPreSum[0] = nums[0];
        rightPreSum[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            leftPreSum[i] = leftPreSum[i - 1] + nums[i];
            int j = n - i - 1;
            if (j >= 0) rightPreSum[j] = rightPreSum[j + 1] + nums[j];
        }

        for (int i = 0; i < n; i++) {
            if (leftPreSum[i] == rightPreSum[i])
                return i;
        }
        return -1;
    }

}
