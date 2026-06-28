class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        // int operations = 0;

        if(arr[0] != 1) {
            arr[0] = 1;
            // operations += 1;
        }

        for(int i=1; i<arr.length; i++) {
            if(arr[i]-arr[i-1] > 1) {
                arr[i] = arr[i-1]+1;
                // operations += 1;
            }
        }
        return arr[arr.length-1];
    }
}
