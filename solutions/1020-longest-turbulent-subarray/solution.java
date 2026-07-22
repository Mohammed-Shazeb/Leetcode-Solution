class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1)
            return 1;
        if (arr.length == 2) {
            if (arr[0] < arr[1] || arr[1] < arr[0]) {
                return 2;
            } 
            return 1;    
        }
        int res = 0;
        int len = 2;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                len = 1;
            }else if (arr[i] > arr[i - 1] && arr[i - 1] < arr[i - 2]) {
                len++;
            } 
            else if (arr[i] < arr[i - 1] && arr[i - 1] > arr[i - 2]) {
                len++;
            } 
            else
                len = 2;

            res = Math.max(res, len);
        }
        return res;
    }
}
