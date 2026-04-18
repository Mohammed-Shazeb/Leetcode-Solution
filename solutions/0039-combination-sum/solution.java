class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> accumulator = new ArrayList<>();
        backtrack(0, 0, target, candidates, accumulator, result);
        return result;
    }

    private void backtrack(int idx, int sum, int target, int[] candidates, List<Integer> accumulator,
            List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(accumulator));
            return;
        }
        if (sum > target || idx == candidates.length) {
            return;
        }
        int num = candidates[idx];
        accumulator.add(num);
        backtrack(idx, sum + num, target, candidates, accumulator, result);
        accumulator.remove(accumulator.size() - 1);
        backtrack(idx + 1, sum, target, candidates, accumulator, result);
    }
}
