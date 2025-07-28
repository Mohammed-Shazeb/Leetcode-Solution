class Solution {
    public static int[] beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        while(ans.size() < n){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int el: ans){
                if (el * 2 - 1 <= n) {
                    temp.add(el * 2 - 1);
                }
            }
            for(int el: ans){
                if (el * 2 <= n) {
                    temp.add(el * 2);
                }
            }
            ans = temp;
        }
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
