class Solution {
    public int minimumPushes(String word) {
        int n  = word.length();
        int res=0;

        int value = 1;

        while (n > 0) {
            int fill = Math.min(8, n);

            res += (value*fill);

            n -= fill;
            value++;
        }
        return res;
    }
}
