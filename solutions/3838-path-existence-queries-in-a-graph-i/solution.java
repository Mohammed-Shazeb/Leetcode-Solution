class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] group = new int[n];
        boolean res[] = new boolean[queries.length];
         
        int groupCount = 0;
        group[0] = groupCount;

        for(int i=1; i<nums.length; i++) {
            if(Math.abs(nums[i-1] - nums[i]) <= maxDiff) {
                group[i] = groupCount;
            }
            else {
                groupCount++;
                group[i] = groupCount;
            } 
        }


        for(int i=0; i<queries.length; i++) {
            int first = queries[i][0];
            int second = queries[i][1];

            if(group[first] == group[second]) {
                res[i] = true;
            }
        }
        return res;
    }
}
