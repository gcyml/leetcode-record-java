# [Min Cost Climbing Stairs][title]

## Description

On a staircase, the `i`-th step has some non-negative cost `cost[i]` assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

**Example 1:**

```
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
```

**Example 2:**

```
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
```

**Note:**

1. `cost` will have a length in the range `[2, 1000]`.
2. Every `cost[i]` will be an integer in the range `[0, 999]`.

**Tags:** Array

**Difficulty:** Easy

## 思路

这种寻找最优解的题目很明显是用动态规划，把问题分解为一步一个阶梯爬上去和跨阶梯上去哪个更省力，即 `dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i])`。此处需要注意的是，顶层对应的体力并没有给出。

``` java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }

        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        if (n == 1) {
            return dp[0];
        }

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
```



[title]: https://leetcode.com/problems/min-cost-climbing-stairs
