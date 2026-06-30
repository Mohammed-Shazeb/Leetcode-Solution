class NumArray {

    int[] tree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        build(nums, 0, 0, n - 1);
    }

    private void build(int[] nums, int i, int start, int end) {
        if (start == end) {
            tree[i] = nums[start];
            return;
        }

        int mid = (start + end) / 2;

        build(nums, 2 * i + 1, start, mid);
        build(nums, 2 * i + 2, mid + 1, end);

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    private int query(int i, int si, int sj, int qi, int qj) {

        // No overlap
        if (sj < qi || si > qj)
            return 0;

        // Complete overlap
        if (qi <= si && sj <= qj)
            return tree[i];

        // Partial overlap
        int mid = (si + sj) / 2;

        return query(2 * i + 1, si, mid, qi, qj) + query(2 * i + 2, mid + 1, sj, qi, qj);
    }

    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }
}
