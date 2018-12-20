# [Maximum Subarray][title]

## Description

Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

**Example:**

```
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation:  [4,-1,2,1] has the largest sum = 6.
```

**Follow up:**

If you have figured out the O( _n_ ) solution, try coding another solution using the divide and conquer approach, which is more subtle.

**Tags:**: Array, Divide and Conquer, Dynamic Programming

**Difficulty:**: Easy

## 思路

题意是找出连续的子数列中的最大总和。这类最优问题都是用动态规划解决，可以把问题看成 `nums[i] > sum+ nums[i] ?`。

``` java
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);    // choose the larger max.  
        }
        return max;
    }
}
```

[title]: https://leetcode.com/problems/maximum-subarray
