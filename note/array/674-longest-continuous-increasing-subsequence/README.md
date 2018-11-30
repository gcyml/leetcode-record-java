# [Longest Continuous Increasing Subsequence][title]

## Description

Given an unsorted array of integers, find the length of longest `continuous` increasing subsequence (subarray).

**Example 1:**

```
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
```

**Example 2:**

```
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1.
```

**Note:** Length of the array will not exceed 10,000.

**Tags:** Array

**Difficulty:** Easy

## 思路

题意是给出一个未排序数组，找出最长递增子数列，返回其长度。题目很简单，线性遍历即可。

``` java
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int len = 1;

        int max = 1;
        for (int i = 1; i < n; i++) {
            len = nums[i] > nums[i - 1] ? len+1 : 1;
            max = Math.max(max, len);
        }
        return max;
    }
}
```



[title]: https://leetcode.com/problems/longest-continuous-increasing-subsequence
