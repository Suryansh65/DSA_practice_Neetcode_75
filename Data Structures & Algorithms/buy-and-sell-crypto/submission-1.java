class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;
        while(sell < n){
            if(prices[sell] < prices[buy]){
                buy = sell;
            }else{
                int profit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit,profit);
            }
            sell++;
        }
        return maxProfit;
    }

}
