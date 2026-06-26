class Solution {

    HashMap<String, Integer> map;
    
    int K;
    public int solve(int i, int jump, int canJumpBack) {
        if(i>K+1) return 0;

        String key = i + "_" + jump + "_" + canJumpBack;

        if(map.containsKey(key)) return map.get(key);

        int count =0;
        if(i==K) count++;

        if(canJumpBack == 1) {
            count += solve(i-1, jump, 0);
        }
        count += solve(i + (1<<jump), jump+1, 1);

        map.put(key, count);
        return count;
    }
    public int waysToReachStair(int k) {
        map = new HashMap<>();
        K = k;

        return solve(1, 0, 1);
    }
}
