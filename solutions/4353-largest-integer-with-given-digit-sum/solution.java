class Solution {
    public int largestInteger(int n, int s) {
        if (s > 9 * n) 
            return -1;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int digit = Math.min(9, s);
            ans.append(digit);
            s -= digit;
        }

        return Integer.parseInt(ans.toString());
    }
}
