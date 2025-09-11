class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tM = 0;
        int tN = 0;
        int[] res = new int[m + n];
        int i = 0;

        while (tM < m && tN < n) {
            if (nums1[tM] <= nums2[tN]) {
                res[i++] = nums1[tM++];
            } else {
                res[i++] = nums2[tN++];
            }
        }

        while (tM < m) {
            res[i++] = nums1[tM++];
        }

        while (tN < n) {
            res[i++] = nums2[tN++];
        }
        for (int j = 0; j < m + n; j++) {
            nums1[j] = res[j];
        }

    }
}
