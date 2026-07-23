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
            System.out.println("i"+i);
            System.out.println("priceDay"+priceDay);
            System.out.println("priceLow"+priceLow);
            System.out.println("priceHigh"+priceHigh);
            if(priceDay<priceLow && i<prices.length-1){
                if(profit>maxProfit){
                    maxProfit=prices[high]-prices[low];
                    System.out.println("profit"+profit);
                }
                
                low=i;
                high=i;
                profit=0;
                System.out.println("low"+low);
                System.out.println("high"+high);
            }
            else if(priceDay>priceHigh){
               high=i;
               profit=prices[high]-prices[low];
               System.out.println("low"+prices[low]);
               System.out.println("high"+prices[high]);
               System.out.println("profit"+profit);
            
            }
            // if(priceDay<priceHigh){
            //     low=i;
            //     high=i;
            //     profit = 0;
            //     System.out.println("low&high"+low+high);
            // }
            // if(profit>maxProfit){
            //     maxProfit=profit;
            //     System.out.println("maxProfit"+maxProfit);
            // }
        }
        return maxProfit>profit?maxProfit:profit;
    }
}
