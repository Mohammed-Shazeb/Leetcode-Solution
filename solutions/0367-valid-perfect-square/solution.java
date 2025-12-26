class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;

        int si = 1;
        int ei = num / 2;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            long sq = (long) mid * mid;

            if (sq == num) {
                return true;
            } else if (sq < num) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return false;
    }
}
