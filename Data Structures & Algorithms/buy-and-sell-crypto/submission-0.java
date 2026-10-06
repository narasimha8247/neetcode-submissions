class Solution {
    public int maxProfit(int[] prices) {
        
        // minimum so far 
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0; i<prices.length; i++){
            int curProfit = prices[i] - min > 0 ? prices[i] - min : 0;
            profit = Math.max(profit, curProfit);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
