class Solution {
    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] visited) {
        
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            visited[i] = true;
            current.add(nums[i]);

            backtrack(nums, result, current, visited);

            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }
   
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), visited);
        return result;
    }
}
