class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int n = nums.length;
        for(int i=0; i<n; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0){
                list.add(Math.abs(nums[i]));
            }else{
                nums[idx] = -nums[idx];
            }
        }
        return list;
    }
}

