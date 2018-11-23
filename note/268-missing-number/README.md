# [Missing Number][title]

## Description

Given an array containing n distinct numbers taken from `0, 1, 2, ..., n`, find the one that is missing from the array.

**Example 1:**

```
Input: [3,0,1]
Output: 2
```

**Example 2:**
```
Input: [9,6,4,2,3,5,7,0,1]
Output: 8
```

**Note:**

Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

**Tags:** Array, Math, Bit Manipulation

**Difficulty:** Easy

## 思路

题意是给定一个包含 `0, 1, 2, ..., n` 中 `n` 个数的序列，找出缺失的数字。另外还要求时间复杂度为线性时间复杂度。思路比较简单，创建一个长度为 `n` 的布尔数组，遍历序列置 `true`，最后布尔数组中为 `false` 的元素索引即缺失数字。时间复杂度为 `O(2n)`。

```java
class Solution {
    public int missingNumber(int[] nums) {
        boolean[] index = new boolean[nums.length+1];
        for(int i : nums) {
            index[i] = true;
        }
        for(int i =0;i<index.length;i++) {
            if(!index[i]) {
                return i;
            }
        }
        return 0;

    }
}
```


[title]: https://leetcode.com/problems/missing-number
