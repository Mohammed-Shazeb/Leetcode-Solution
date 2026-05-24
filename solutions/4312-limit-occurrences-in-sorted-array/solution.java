class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int freq[] = new int[101];

        for (int i = 0; i < nums.length; i++) {

            if (freq[nums[i]] < k) {
                res.add(nums[i]);
                freq[nums[i]]++;
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
