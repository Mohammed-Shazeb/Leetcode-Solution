class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int windowSum = 0;
        int count = 0;

        // Sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        if(windowSum>=threshold*k) count++;
        
        for(int i=1;i<arr.length-k+1;i++){
            windowSum = windowSum + arr[i+k-1] - arr[i-1];
           if(windowSum>=threshold*k) count++;
        }
        return count;
    }
}
