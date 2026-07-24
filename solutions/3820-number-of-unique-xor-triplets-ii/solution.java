class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        boolean[] pair = new boolean[2048];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pair[nums[i] ^ nums[j]] = true;
            }
        }

        boolean[] ans = new boolean[2048];

        for (int num : nums) {
            for (int x = 0; x < 2048; x++) {
                if (pair[x]) {
                    ans[num ^ x] = true;
                }
            }
        }

        int count = 0;
        for (boolean b : ans) {
            if (b) count++;
        }
        return count;
    }
}
