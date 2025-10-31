class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        int result[] = new int[2];

        int i=1;
        int count = 0;
        int j = 0;
        while(i<nums.length){
            if(nums[i-1] == nums[i]){
                result[j++] = nums[i];
                count++;
            }
            if(count == 2) break;
            i++;
        }
        return result;
    }
}
