class Solution {
    private int[] manacher(int[] seq, int sentinel) {
        int m = seq.length;
        int[] s = new int[2 * m + 1];
        Arrays.fill(s, sentinel);
        for (int i = 0; i < m; ++i) {
            s[2 * i + 1] = seq[i];
        }
        int n = s.length;
        int[] p = new int[n];
        int c = 0, r = 0;
        for (int i = 0; i < n; ++i) {
            if(i<r) {
                p[i] = Math.min(r-i, p[2*c-i]);
            }

            while(i-p[i]-1>=0 && i+p[i]+1<n && s[i - 1 - p[i]] == s[i + 1 + p[i]]) {
                p[i]++;
            }

            if(i+p[i]>r) {
                c= i;
                r = i+p[i];
            }
        }
        return p;
    }

    public long getSum(int[] A) {
        int n = A.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + A[i];
        }
        int[] p = manacher(A, 0);
        long res = 0, cur = 0;
        for (int i = 0; i < n + n + 1; ++i) {
            cur = pre[(i + p[i]) / 2] - pre[(i - p[i]) / 2];
            res = Math.max(res, cur);
        }
        return res;
    }
}
