import java.util.*;
class Solution {
    public static void findSubsets(int[] nums, List<List<Integer>> result, List<Integer> current, int i) {
        // Base case: reached end of array
        if (i == nums.length) {
            result.add(new ArrayList<>(current)); // add a copy of current subset
            return;
        }

        // Include nums[i] in the current subset
        current.add(nums[i]);
        findSubsets(nums, result, current, i + 1);

        // Exclude nums[i] from the current subset
        current.remove(current.size() - 1);
        findSubsets(nums, result, current, i + 1);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(nums, result, new ArrayList<>(), 0);
        return result;
    }

}

