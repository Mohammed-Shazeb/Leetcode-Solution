class Solution {
    public boolean checkGoodInteger(int n) {
        int squareSum =0;
        int digitSum = 0; 
        while(n>0) {
            int rem = n%10;
            digitSum += rem;
            squareSum += (rem*rem);
            n = n/10;
        }
        if(squareSum - digitSum >= 50) return true;
        return false;
    }
}
