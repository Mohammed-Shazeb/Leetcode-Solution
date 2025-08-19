class Solution {
    public int singleNonDuplicate(int[] nums) {
        // int result = 0;
        // for (int num : nums) {
        //     result ^= num;
        // }
        // return result;
        int si = 0;
        int ei = nums.length - 1;
        int n = nums.length;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (n == 1) return nums[0];
            if(mid == 0 && nums[0]!=nums[1]) return nums[0];
            if(mid == n-1 && nums[n-1]!=nums[n-2]) return nums[mid];

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];
            
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid-1]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }

        }
        return -1;
    }
}
