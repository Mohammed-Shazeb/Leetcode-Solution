class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 1. Initial check
        if (nums == null || nums.length < 4)
            return new ArrayList<>();

        // 2. Sort the array
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // 3. Fix the first element
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 4. Two-pointer approach
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // Need a bigger sum
                    } else {
                        right--; // Need a smaller sum
                    }
                }
            }

        }
        return result;
    }
}
