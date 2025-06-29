class Solution {
    public static int hammingWeight(int n) {
        int bitMask = n>>1;
        int count = 0;
        while (n != 0 ) {
            if((n & 1) == 1) count ++;
            n = n>>1;
        }
        return count;
    }
    public static void main(String[] args){
        int n = 11;
        System.out.println(hammingWeight(n));
    }
}
