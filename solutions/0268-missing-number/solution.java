class Solution {
    public int missingNumber(int[] nums) {
        int n_xor = nums.length;  // start with n

        for (int i = 0; i < nums.length; i++) {
            n_xor = n_xor ^ i;       // XOR with index
            n_xor = n_xor ^ nums[i]; // XOR with array element
        }

        return n_xor; // final result = missing number
    }
}

