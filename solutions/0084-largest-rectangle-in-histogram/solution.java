class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;   
        int nextSmallerRight[] = new int[n];
        int nextSmallerLeft[] = new int[n];
        
        // next Smaller Right
        Stack<Integer> s = new Stack<>();
        for(int i=n-1; i>=0; i--) {

            while(!s.isEmpty() && heights[s.peek()]>=heights[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nextSmallerRight[i] = n;
            } else {
                nextSmallerRight[i] = s.peek();
            }
            s.push(i);
        }

        // next Smaller Left
        s = new Stack<>();
        for(int i=0; i<n; i++) {
            
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nextSmallerLeft[i] = -1;
            } else {
                nextSmallerLeft[i] = s.peek();
            }
            s.push(i);
        }

        int maxArea = 0;
        for(int i=0; i<n; i++) {
            int height = heights[i];
            int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;
            int area = height*width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    } 
}
