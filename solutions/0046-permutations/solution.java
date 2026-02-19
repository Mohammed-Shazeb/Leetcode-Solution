class Solution {

    public static void backtrack(List<List<Integer>> resultList, ArrayList<Integer> ans, int[] nums) {
        // If we match the length, it is a permutation
        if(ans.size() == nums.length) {
            resultList.add(new ArrayList<>(ans));
            return;
        }

        for(int num:nums) {
            if (ans.contains(num)) {
                continue;
            }
            ans.add(num);
            backtrack(resultList, ans, nums);
            ans.remove(ans.size()-1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList,new ArrayList<>(),nums);
        return resultList;
    }
}
