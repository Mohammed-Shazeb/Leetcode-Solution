class Solution {
    public int fib(int n) {
        int[] memo = new int[n + 1]; // array to store results
        return fibMemo(n, memo);
    }

    private int fibMemo(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] != 0) return memo[n]; // already computed
        memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        return memo[n];
    }
}

