class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int lp = 0;
        int rp = n-1;
        int max = 0;
        while(lp<rp){
            int width = rp-lp;
            int heigh = Math.min(height[lp], height[rp]);
            int area = heigh*width;
            max = Math.max(max,area);
            if(height[lp]<height[rp]) lp++;
            else rp--;
        }
        return max;
    }
}
