class Solution {
    public void sortColors(int[] nums) {
       
        // int count[] = new int[max + 1];
        // for (int i = 0; i < nums.length; i++) {
        //     count[nums[i]]++;
        // }
        // int j = 0;
        // for (int i = 0; i < count.length; i++) {
        //     while (count[i] > 0) {
        //         nums[j] = i;
        //         j++;
        //         count[i]--;
        //     }
        // }


        // int count0 = 0;
        // int count1=0;
        // int count2=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i] ==0){
        //         count0++;
        //     }
        //     else if(nums[i]==1){
        //         count1++;
        //     }
        //     else{
        //         count2++;
        //     }
        // }
        // int idx = 0;
        // for(int i=0;i<count0;i++){
        //     nums[idx++] = 0;
        // }
        // for(int i=0;i<count1;i++){
        //     nums[idx++] = 1;
        // }
        // for(int i=0;i<count2;i++){
        //     nums[idx++] = 2;
        // }

        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,mid++,low++);
            }
            else if(nums[mid] ==1){
                mid++;
            }
            else{
                swap(nums,mid,high--);
            }
        }
    }
    public static void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
