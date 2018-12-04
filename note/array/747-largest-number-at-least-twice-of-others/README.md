# [Largest Number At Least Twice of Others][title]

## Description

In a given integer array `nums`, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as every other number in the array.

If it is, return the index of the largest element, otherwise return -1.

**Example 1:**

```
Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
```

**Example 2:**

```
Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
```

**Note:**

1. `nums` will have a length in the range `[1, 50]`.
2. Every `nums[i]` will be an integer in the range `[0, 99]`.

**Tags:** Array

**Difficulty:** Easy

## 思路

题意是找出数组中，至少是其他数字两倍的最大数。这个问题可以变成**最大数是否为数值第二大的两倍**，只要满足此条件，即符合所有条件。

``` java
class Solution {
    public int dominantIndex(int[] nums) {
        int secondMax = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i< nums.length;i++) {
            if(nums[i] > max) {
                secondMax = max;
                max = nums[i];
                index = i;
            } else {
                secondMax = Math.max(nums[i], secondMax);
            }
        }
        if(secondMax *2  <= max ) {
            return index;
        }
        return -1;
    }
}
```

[title]: https://leetcode.com/problems/largest-number-at-least-twice-of-others
