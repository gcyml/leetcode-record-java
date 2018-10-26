class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int cash = 0;   // 手上没股票时的收益
        int hold = -prices[0];  // 手上有股票的收益

        for(int i=1;i<prices.length;i++) {
            cash = Math.max(cash, prices[i] + hold);
            hold = Math.max(hold, cash-prices[i]);
        }
        return cash;
    }
}