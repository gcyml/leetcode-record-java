# [Array Partition I][title]

## Description

Given an array of **2n** integers, your task is to group these integers into **n** pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

**Example 1:**

```
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
```

**Note:**

1. **n** is a positive integer, which is in the range of [1, 10000].
2. All the integers in the array will be in the range of [-10000, 10000].

**Tags:** Array

**Difficulty:** Easy

## 思路

快速排序

``` java
class Solution {
    public int arrayPairSum(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i+=2) {
            res += nums[i];
        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/array-partition-i
