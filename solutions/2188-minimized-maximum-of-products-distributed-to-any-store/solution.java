class Solution {
    private int getMax(int[] quantities) {
        int max = 0;
        for (int quantity : quantities) {
            max = Math.max(max, quantity);
        }
        return max;
    }

    public static boolean isValid(int n, int[] quantites, int mid) {
        int requiredStore = 0;
        for (int quantity : quantites) {
            requiredStore += ((quantity + mid-1)/mid);
        }
        return requiredStore <= n;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int si = 1;
        int ei = getMax(quantities);
        int res = ei;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (isValid(n, quantities, mid)) {
                res = mid;
                ei = mid - 1;
            } else
                si = mid + 1;
        }
        return res;
    }
}
