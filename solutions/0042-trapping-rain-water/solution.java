class Solution {
    public static int trap(int[] height) {
        int n = height.length;
        // left max
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);  
        }

        // right max
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(height[i],rightMax[i+1]);  
        }
        // trapped water = min(leftMax, rightMax)
        int trappedWater = 0;
        for(int i=0;i<n;i++){
            height[i] = Math.min(leftMax[i],rightMax[i]) - height[i];
            trappedWater += height[i];
        }
        // water level = min(leftMax, rightMax) - height
        return trappedWater;
    }
    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
