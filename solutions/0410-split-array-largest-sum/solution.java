class Solution {
    private boolean isValid(int nums[], int k, int mid) {
        int subArrSum = 0;
        int split = 1;

        for (int num : nums) {
            if(num > mid) return false;
            if (num + subArrSum <= mid) {
                subArrSum += num;
            } else {
                split++;
                subArrSum = num;
            }
        }

        return split > k ? false : true;
    }

    public int splitArray(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int start = 0;
        int end = sum;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (isValid(nums, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
