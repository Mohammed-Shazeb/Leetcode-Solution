class Solution {
    private boolean isValid(int nums[], int k, int mid) {
        int subArrSum = 0;
        int split = 1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > mid) return false;
            if(nums[i] + subArrSum <= mid) {
                subArrSum += nums[i];
            } else {
                split++;
                subArrSum = nums[i];
            }
        }
        return split>k?false:true;
    }
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        for(int num:nums) {
            sum += num;
        }
        int start = 0;
        int end = sum;
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(isValid(nums, k, mid)) {
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}
