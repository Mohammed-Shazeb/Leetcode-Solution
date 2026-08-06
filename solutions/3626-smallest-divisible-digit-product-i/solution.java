class Solution {
    public static int helper(int n) {
        int product = 1;
        
        while (n > 0) {
            int digit = n % 10;  
            product *= digit;    
            n /= 10;
        }        
        return product;
    }
    public int smallestNumber(int n, int t) {
        int ans = 1;
        for(int i=n;i<n+10;i++) {
            int mult = helper(i);

            if(mult%t==0) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
