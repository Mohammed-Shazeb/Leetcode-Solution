class Solution {
    public int maxProfit(int[] price){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int profit = 0;

        for(int i=1;i<price.length;i++){
            if(price[i] > price[i-1]) {
                profit = price[i] - price[i-1];
                maxProfit += profit;
            }
            else{
                buyPrice = price[i];
            }
            profit = 0;
        }
        return maxProfit;
    }
}
