class Solution {

    static final int MOD = 1_000_000_007;

    public List<Integer> getDiv(int n) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);

                if (i != n / i)
                    divisors.add(n / i);
            }
        }

        return divisors;
    }

    public int kadane(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int x : nums) {
            currSum += x;
            maxSum = Math.max(maxSum, currSum);

            if (currSum < 0)
                currSum = 0;
        }

        return maxSum;
    }

    public int divisibleGame(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            List<Integer> divs = getDiv(num);

            for (int d : divs) {
                if (d > 1)
                    set.add(d);
            }
        }

        // Edge case: all numbers are 1
        if (set.isEmpty()) {
            long ans = (-2L) % MOD;
            if (ans < 0)
                ans += MOD;
            return (int) ans;
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int bestDiff = Integer.MIN_VALUE;
        int bestK = Integer.MAX_VALUE;

        for (int k : list) {

            int[] temp = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {

                if (nums[i] % k == 0)
                    temp[i] = nums[i];
                else
                    temp[i] = -nums[i];
            }

            int diff = kadane(temp);

            if (diff > bestDiff) {
                bestDiff = diff;
                bestK = k;
            }
            // else if (diff == bestDiff && k < bestK) {
            //     bestK = k;
            // }
        }

        long ans = (1L * bestDiff * bestK) % MOD;

        if (ans < 0)
            ans += MOD;

        return (int) ans;
    }
}
