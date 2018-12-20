# [Climbing Stairs][title]

## Description

You are climbing a stair case. It takes _n_ steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

**Note:** Given _n_ will be a positive integer.

**Example 1:**

```
Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
```

**Example 2:**

```
Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

**Tags:**: Dynamic Programming

**Difficulty:**: Easy

## 思路

题意是每步只能跨一阶或两阶楼梯，有多少种方法到达楼顶。这题和[Min Cost Climbing Stairs][note-746] 差不多，同样采用动态规划，由于到达楼顶的方法只能由到达前一阶的方法数和到达前两阶梯的方法决定，即 `dp[i] = dp[i-1] + dp[i-2]`

``` java
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;  
        int a = 1, b = 1, res = 5;  
        for (int i = 2; i <= n; i++)  
        {  
            res = a + b;
            b = a;
            a = res;
        }  
        return res;  
    }
}
```

[title]: https://leetcode.com/problems/climbing-stairs
[note-746]: https://github.com/gcyml/leetcode-record-java/tree/master/note/array/746-min-cost-climbing-stairs
