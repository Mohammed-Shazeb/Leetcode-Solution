class Solution {
    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result,
            int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (sum > target)
            return;

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            current.add(candidates[i]);
            backtrack(candidates, target, i + 1, current, result, sum + candidates[i]);
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result, 0);
        return result;
    }
}
