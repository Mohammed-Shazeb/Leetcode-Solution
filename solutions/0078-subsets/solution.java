class Solution {
    public void backtrack(int nums[], List<List<Integer>> res, List<Integer> curr, int i) {
       
        if (i == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
       
        backtrack(nums, res, curr, i + 1);
        curr.remove(curr.size() - 1);
        backtrack(nums, res, curr, i + 1);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;
    }
}
