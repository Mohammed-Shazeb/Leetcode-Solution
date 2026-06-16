class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int res = 0;

        for(int i=1; i<n-1; i++) {
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                int length = 0;
                // find the peak now traverse through the left and the right part and chech the condition and res++

                // left part
                int k = i;
                while(k>0 && arr[k] > arr[k-1]) {
                    length++;
                    k--;
                }

                // right part
                k = i;
                while(k<n-1 && arr[k] > arr[k+1]) {
                    length++;
                    k++;
                }
                length++;
                res = Math.max(res, length);
            }
        }
        return res;
    }
}
