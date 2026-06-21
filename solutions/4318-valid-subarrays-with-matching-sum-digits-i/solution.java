class Solution {
    public int countValidSubarrays(int[] nums, int x) {
         // 1, 101, 102 prefix sum

        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int count = 0;

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {

                long sum = prefix[end + 1] - prefix[start];

                int lastDigit = (int)(sum % 10);

                long first = sum;
                while (first >= 10) {
                    first /= 10;
                }

                int firstDigit = (int) first;

                if (firstDigit == x && lastDigit == x) {
                    count++;
                }
            }
        }

        return count;
    }
}
