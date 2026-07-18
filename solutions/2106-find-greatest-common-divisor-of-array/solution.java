class Solution {
    public  int gcd(int a, int b) {
        return  b == 0 ? a : gcd(b,a%b);
    }

    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        for(int num : nums) {
            max = (num > max) ? num : max;
            min = (num < min) ? num : min;
        }
        return gcd(max, min);
    }
}
