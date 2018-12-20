# [Maximum Average Subarray I][title]

## Description

Given an array consisting of `n` integers, find the contiguous subarray of given length `k` that has the maximum average value. And you need to output the maximum average value.

**Example 1:**

```
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
```

**Note:**

1. 1 <= `k` <= `n` <= 30,000.
2. Elements of the given array will be in the range [-10,000, 10,000].

**Tags:** Array

**Difficulty:** Easy

## 思路

题意是找到具有最大平均值的给定长度 `k` 的连续子数组，其实就是找出长度为 `k` 的最大连续子数组。

``` java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avr = 0, sum = 0;
        for(int i = 0;i < k;i++) {
            sum += nums[i];
        }
        avr = sum/k;
        for(int i = k;i<nums.length;i++) {
            sum = sum - nums[i-k] + nums[i];
            avr = Math.max(sum/k, avr);
        }
        return avr;
    }
}
```

[title]: https://leetcode.com/problems/maximum-average-subarray-i
