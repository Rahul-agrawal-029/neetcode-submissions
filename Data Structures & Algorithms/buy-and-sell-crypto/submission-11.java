class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int low = 0;
        int high = 0;
        int profit = 0;
        for (int i = 0; i < prices.length ; i++){
            int priceDay=prices[i];
            int priceLow=prices[low];
            int priceHigh=prices[high];
            if(priceDay<priceLow && i<prices.length-1){
                if(profit>maxProfit){
                    maxProfit=prices[high]-prices[low];
                }
                
                low=i;
                high=i;
                profit=0;
            }
            else if(priceDay>priceHigh){
               high=i;
               profit=prices[high]-prices[low];
            
            }
        }
        return maxProfit>profit?maxProfit:profit;
    }
}
