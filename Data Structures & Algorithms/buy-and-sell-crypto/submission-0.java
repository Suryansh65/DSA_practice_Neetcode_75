class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int buy = prices[0];
        for(int i=1;i<n;i++){
            int price = prices[i];
            if(price > buy){
                // chances of profit
                int profit = price - buy;
                maxProfit = Math.max(maxProfit,profit);
            }else{
                buy = prices[i];
            }
        }
        return maxProfit;
    }
}
