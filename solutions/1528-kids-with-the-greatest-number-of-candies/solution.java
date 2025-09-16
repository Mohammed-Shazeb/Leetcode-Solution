class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        List<Boolean> list = new ArrayList<>();
        int n = candies.length;
        for(int i=1;i<n;i++){
            if(max<candies[i]) max = candies[i];
        }
        for(int i=0;i<n;i++){
            if(candies[i]+extraCandies >= max) list.add(true);
            else list.add(false);
        }
        return list;
    }
}
