class Solution {
    public boolean isHappy(int n) {
        if(n == 1 || n==7) return true;
        while(n>9){
            int sum = 0;
            while (n > 0) {
                int ld = n % 10;
                sum += ld * ld;
                n /= 10;
            }
            n = sum;
            if(sum == 1|| sum == 7){
                return true;
            }
        }
        return false;
    }
}
