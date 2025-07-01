class Solution {
    public static double myPow(double x, long n) {
        if(n==0) {
            return 1;
        }
        if( n<0){
            return 1/myPow(x,-n);
        }
        double half = myPow(x,n/2);
        double halfSq = half * half;
        if(n%2 !=0){
            return x * halfSq;
        }
        return halfSq;
    }
    public static void main (String[] args){
        double x = 2.00000;
        long n = 10;
        System.out.println(myPow(x,n));
    }
}
