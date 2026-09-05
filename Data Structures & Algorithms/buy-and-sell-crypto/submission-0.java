class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            int current = prices[i];
            int profit = Integer.MIN_VALUE;
            for(int j=i+1;j<n;j++){
                profit = Math.max(profit,prices[j] -current);
                maxProfit = Math.max(profit,maxProfit);
            }
        }
        return Math.max(0,maxProfit);
    }
}
