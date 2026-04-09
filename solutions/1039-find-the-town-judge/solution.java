class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 1) return 1;

        int indeg[] = new int[n+1];
        int outdeg[] = new int[n+1];
        for(int arr[]: trust){
            int outdegree = arr[0]; 
            int indegree = arr[1];
            indeg[indegree]++;
            outdeg[outdegree]++;
        }
        for (int i = 1; i <= n; i++) {  
            if (indeg[i] == n - 1 && outdeg[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
