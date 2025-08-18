class Solution {
    public static int helper(int[] arr, int target, int si, int ei){
        int mid = si +(ei-si)/2;
        if(si>ei){
            return -1;
        }
        if(arr[mid] == target){
            return mid;
        }
        // Left side is sorted
        if (arr[si] <= arr[mid]) {
            if (arr[si] <= target && target <= arr[mid]) {
                return helper(arr, target, si, mid - 1);
            } else {
                return helper(arr, target, mid + 1, ei);
            }
        } 
        // Right side is sorted
        else {
            if (arr[mid] <= target && target <= arr[ei]) {
                return helper(arr, target, mid + 1, ei);
            } else {
                return helper(arr, target, si, mid - 1);
            }
        }
    }
    public int search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length-1;
        return helper(nums, target, si,ei);
        
    }
}
