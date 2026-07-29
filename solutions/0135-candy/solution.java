class Solution {
    public int candy(int[] ratings) {
        // 1 - n-2, count = n rat[i]>i+1 i>i-1 c++
        int n = ratings.length;
        int count = 0;
        int ans[] = new int[n];
        Arrays.fill(ans,1);

        for(int i=1;i<n;i++) {
            if(ratings[i]>ratings[i-1]) {
                ans[i] = Math.max(ans[i], ans[i-1]+1);
            }
        }
        for(int i=n-2;i>=0;i--) {
            if(ratings[i]>ratings[i+1]) {
                ans[i] = Math.max(ans[i], ans[i+1]+1);
            }
        }
       for(int num:ans) count += num;
       return count;
        
    }
}
