class Solution {
    public void helper(int nums[], List<Integer> list) {

        for(int i=nums.length-1; i>=0; i--) {
            while (nums[i] > 0) {
                list.add(nums[i] % 10); 
                nums[i] /= 10;
            }
        }
    }
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        helper(nums, list);
        Collections.reverse(list);
        
        int arr[] = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
