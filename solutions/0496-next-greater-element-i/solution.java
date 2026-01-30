class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int idx = 0;
        int res[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int curr = nums1[i];
            int k = 0;
            while(k < nums2.length && curr != nums2[k] ) {
                k++;
            }

            boolean found = false;
            for (int j = k+1; j < nums2.length; j++) {
                if (curr < nums2[j]) {
                    res[idx++] = nums2[j];
                    found = true;
                    break;
                    // if (idx <= nums1.length - 1) {
                    //     res[idx++] = nums2[j];
                    //     break;
                    // }
                }
                // else{
                //     if (idx <= nums1.length - 1) {
                //         res[idx++] = -1;
                //     }
                // }
            }
            if (!found) {
                res[idx++] = -1;
            }
        }
        return res;
    }
}
