# [Maximum Subarray][title]

## Description

Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

**Example:**

```
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

**Follow up:**

If you have figured out the O(*n*) solution, try coding another solution using the divide and conquer approach, which is more subtle.

**Tags:** Array, Divide and Conquer, Dynamic Programming

**Difficulty:** Easy

## 思路

题意是求数组中子数组的最大和，这种最优问题一般第一时间想到的就是动态规划，我们可以这样想，当部分序列和大于零的话就一直加下一个元素即可，并和当前最大值进行比较，如果出现部分序列小于零的情况，那肯定就是从当前元素算起。其转移方程就是 `dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);`，由于我们不需要保留 dp 状态，故可以优化空间复杂度为 1，即 `dp = nums[i] + (dp > 0 ? dp : 0);`。

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length, dp = nums[0], max = dp;
        for (int i = 1; i < len; ++i) {
            dp = nums[i] + Math.max(dp, 0);
            max = Math.max(max, dp);
        }
        return max;
    }
}
```

上述代码也可简化为下面的例子。只创建 `sum` 和 `max` 两个变量，若 `sum + nums[i]` 小于 `nums[i]`, 则 `sum` 并不是最大和，从索引 `i` 重新开始记和。

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
```




[title]: https://leetcode.com/problems/maximum-subarray
