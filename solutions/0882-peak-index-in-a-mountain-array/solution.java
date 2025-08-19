class Solution {
    // public static int helper(int[] arr, int si, int ei){
    //     int mid = si + (ei-si)/2;
    //     if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) return mid;

    //     if(arr[mid] < arr[mid+1]){
    //         return helper(arr,mid,ei);
    //     }else{
    //         return helper(arr,si,mid);
    //     }
    // }
    // public int peakIndexInMountainArray(int[] arr) {
    //     int si = 0;
    //     int ei = arr.length-1;
    //     return helper(arr, si, ei);

    // }

    public int peakIndexInMountainArray(int[] arr) {
        int si = 1;
        int ei = arr.length - 2;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }

        }
        return -1;

    }
}
