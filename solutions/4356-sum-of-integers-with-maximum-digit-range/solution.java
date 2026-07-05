class Solution {
    public int maxDigitRange(int[] nums) {
        int range[] = new int[nums.length];
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            int maxDigit = Integer.MIN_VALUE;
            int minDigit = Integer.MAX_VALUE;
            int count = 0;

            while (n > 0) {
                int rem = n % 10;
                maxDigit = Math.max(maxDigit, rem);
                minDigit = Math.min(minDigit, rem);

                n = n/10;
                count++;
            }
            range[i] = maxDigit - minDigit;
        }
        int maxNoRange = 0;
        for(int i=0; i<nums.length; i++) {
            maxNoRange = Math.max(maxNoRange, range[i]);
        }
        for(int i=0; i<nums.length; i++) {
            if(maxNoRange == range[i]) {
                ans += nums[i];
            }
        }
        return ans;
    }
}
