class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        
        for(int i=0; i<k; i++) {
            sum += cardPoints[i];  
        }

        int maxSum = sum;
        int idx = cardPoints.length - 1;
        int rightSum = 0;
        
        for(int i=k-1; i>=0; i--) {
            sum -= cardPoints[i];
            rightSum += cardPoints[idx--];
            maxSum = Math.max(maxSum, sum+rightSum);
        }
        return maxSum;
    }
}
