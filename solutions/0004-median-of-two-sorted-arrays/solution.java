class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combined = new int[nums1.length + nums2.length];

        // System.arraycopy(sourceArray, sourceStartIndex, destinationArray, destinationStartIndex, numberOfElements);
        System.arraycopy(nums1, 0, combined, 0, nums1.length);
        System.arraycopy(nums2, 0, combined, nums1.length, nums2.length);
        Arrays.sort(combined);
        int n = combined.length;
        if (n % 2 == 1) {
            // return the middle element
            return combined[n / 2];
        } else {
            // Even length → average the two middle elements
            return (combined[n / 2 - 1] + combined[n / 2]) / 2.0;
        }
    }
}
