# [Best Time to Buy and Sell Stock][title]

## Description

Say you have an array for which the *i*<sup>th</sup> element is the price of a given stock on day *i*.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

**Example 1:**

```
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
```

**Example 2:**

```
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

**Tags:** Array, Dynamic Programmin

**Difficulty:** Easy

## 思路

题意是给出一个数组代表每天的股票金额，让你在最多买卖一次的情况下算出最大的收益额。类似这种最优问题，直接动态规划即可。

```java
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length==0) return 0;
        int res = 0;
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            res = Math.max(res, prices[i] - minPrice);
        }
        return res;
    }
}
```




[title]: https://leetcode.com/problems/best-time-to-buy-and-sell-stock
