class Solution {
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int n = nums.length;
        int[] rightMax = new int[n];

        rightMax[n - 1] = Integer.MIN_VALUE;
        int max = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = max;
            max = Math.max(max, nums[i]);
        }

        int maxLeft = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (nums[i] > maxLeft || nums[i] > rightMax[i]) {
                res.add(nums[i]);
            }

            maxLeft = Math.max(maxLeft, nums[i]);
        }

        return res;
    }
}
