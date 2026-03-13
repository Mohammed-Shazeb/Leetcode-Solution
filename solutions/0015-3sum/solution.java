class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 1. Initial check
        if (nums == null || nums.length < 3) return new ArrayList<>();

        // 2. Sort the array
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        // 3. Fix the first element
        for (int i = 0; i < nums.length - 2; i++) {
            
            // 4. Two-pointer approach
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Need a bigger sum
                } else {
                    right--; // Need a smaller sum
                }
            }
        }
        return new ArrayList<>(result);
    }
}


