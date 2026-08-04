class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        for(int n:nums) {
            set.add(n);
        }

        int n = nums.length;
        int start = nums[0];
        int end = nums[n-1];
        List<Integer> list = new ArrayList<>();
        for(int i=start+1;i<end;i++) {
            if(!set.contains(i)) list.add(i);
        }
        return list;
    }
}
