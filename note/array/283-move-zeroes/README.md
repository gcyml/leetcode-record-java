# [Move Zeroes][title]

## Description

Given an array `nums`, write a function to move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

**Example:**

```
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
```

**Note:**

1. You must do this **in-place** without making a copy of the array.
2. Minimize the total number of operations.

**Tags:** Array, Two Pointers

**Difficulty:** Easy

## 思路

题意是给定一个数组 `nums`，编写一个函数将所有 `0` 移动到数组的末尾，同时保持非零元素的相对顺序。解法很简单，遍历元素把非零元素按次写入，后面的元素置零即可。

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for(int i = index;i<nums.length;i++) {
            nums[i] = 0;
        }
    }
}
```

[title]: https://leetcode.com/problems/move-zeroes
