class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int n = nums.length;
        // int ans[] = new int[n];
        // int mult = 1;
        // for (int i = 0; i < n; i++) { 
        //     int curr = nums[i]; 
        //     for (int j = 0; j < n; j++) {
        //         if (i != j) { 
        //             mult *= nums[j];    
        //         }
        //     }
        //     ans[i] = mult;
        //     mult = 1;
        // }
        // return ans;

        int n = nums.length;
        int ans[] = new int[n];
        ans[0] = 1;
        for(int i=1;i<n;i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        int suffix = 1;
        for(int i=n-2;i>=0;i--){
            suffix *= nums[i+1];
            ans[i] *= suffix;  
        }
        return ans;
    }
}
