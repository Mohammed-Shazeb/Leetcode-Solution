/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int peakIndexInMountainArray(MountainArray mountainArr) {
        int si = 1;
        int ei = mountainArr.length() - 2;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            int midVal = mountainArr.get(mid);
            int left = mountainArr.get(mid - 1);
            int right = mountainArr.get(mid + 1);

            if (left < midVal && midVal > right) {
                return mid;
            } else if (midVal < right) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return -1;

    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakIndexInMountainArray(mountainArr);
        int si = 0;
        int ei = peak;

        // ascending part
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        // descending part
        si = peak+1;
        ei = mountainArr.length() - 1;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            int midVal = mountainArr.get(mid);
 
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return -1;
    }
}
