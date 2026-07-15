class Solution {
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
    public int gcdOfOddEvenSums(int n) {
        int sumOdd =0, sumEven=0;
        for(int i=1; i<=2*n;i++) {
            if(i%2==0) sumEven+=i;
            else sumOdd += i;
        }
        return gcd(sumOdd, sumEven);
        // return n;
    }
}
