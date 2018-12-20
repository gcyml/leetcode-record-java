# [Reshape the Matrix][title]

## Description

Given an integer array, you need to find one **continuous subarray** that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the **shortest** such subarray and output its length.

**Example 1:**

```
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
```

**Note:**

1. Then length of the input array is in range [1, 10,000].
2. The input array may contain duplicates, so ascending order here means **<=**.

**Tags:** Array

**Difficulty:** Easy

## 思路

题意是找出最短无序数组。思路是把原数组和排序后数组比对，找出位置发生变化的起始点 `start` 和终点 `end`。

``` java
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] origin = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int start = -1, end = -2;
        for(int i =0;i<nums.length;i++){
            if(nums[i] != origin[i]) {
                if(start == -1) {
                    start = i;
                }
                end = i;
            }
        }
        return end- start +1;

    }
}
```

[title]: https://leetcode.com/problems/shortest-unsorted-continuous-subarray
