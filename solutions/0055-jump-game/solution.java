class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;        
        boolean t[] = new boolean[n];
        // Arrays.fill(t, -1);
        //t[i] = True means, you can reach index i
        
        t[0] = true; //Already at starting index
        
        for(int i = 1; i<n; i++) {
            for(int j = i-1; j>=0; j--) {
                if(j + nums[j] >= i && t[j]) { //here t[j] == true means you should be able to reach j also, 
                                               //then only you can plan to jump(j+nums[i])  from this jth index
                    t[i] = true;
                    break;
                }
            }
        }

        return t[n-1];
    }
}
