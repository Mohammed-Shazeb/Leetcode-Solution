class Solution {
    public long maximumValue(int n, int s, int m) {
        if(n == 1) return s;
        if(n==2) return s+m;
        long arr0 = s;
        long arr1 = s + m;

        
        int lastIndex = n - 1;

        int lastEvenIdx = (lastIndex % 2 == 0) ? lastIndex : lastIndex - 1;
        int lastOddIdx = (lastIndex % 2 == 1) ? lastIndex : lastIndex - 1;

        long evenK = lastEvenIdx / 2; 
        long oddK = lastOddIdx / 2;  

        long maxEven = arr0 + (m - 1) * evenK; 

        long maxOdd = arr1 + (m - 1) * oddK;   

        long max = Math.max(maxEven, maxOdd);
        return max;
    }
}
