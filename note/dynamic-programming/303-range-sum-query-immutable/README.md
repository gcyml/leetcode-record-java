# [Range Sum Query - Immutable][title]

## Description

Given an integer array _nums_ , find the sum of the elements between indices
_i_ and _j_ ( _i_ ≤ _j_ ), inclusive.

**Example:**  

```
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
```

**Note:**  

1. You may assume that the array does not change.
2. There are many calls to _sumRange_ function.

**Tags:**: Dynamic Programming

**Difficulty:**: Easy

## 思路

题意是定义一个指定索引间的总和的方法。由于数组不会变化，因此该方法要保证效率，时间复杂度应该要保证 `O(1)`。用动态规划的方法保存每一个数列之前(包括自己)的元素总和，则 `sumRange(i,j) = dp[j] - dp[i-1]`。

``` java
class NumArray {
    private int[] sums;
    public NumArray(int[] nums) {
        this.sums = new int[nums.length];
        int sum = 0;
        for(int i = 0; i<nums.length;i++) {
            sums[i] = sum + nums[i];
            sum = sums[i];
        }
    }

    public int sumRange(int i, int j) {
        return i== 0? sums[j]: sums[j] - sums[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
```

[title]: https://leetcode.com/problems/range-sum-query-immutable
