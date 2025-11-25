class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        int count;
        for(int i=0;i<n;i++){
            count = 0;
            for(int j=0;j<n;j++){
                if( j != i && nums[j] < nums[i]) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
