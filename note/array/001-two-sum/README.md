# [Two Sum][title]

## Description

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have ***exactly*** one solution, and you may not use the same element twice.

**Example:**

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

**Tags:** Array, Hash Table

**Difficulty:** Easy

## 思路

题意是让你从给定的数组中找到两个元素的和为指定值的两个索引，用dp数组存入 ` target - nums[i] `,然后遍历索引为 `0 <= j < i` 的元素 `nums[j`， 若 `nums[j] == dp[i]`, 则返回 `i` 和 `j`。

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        int[] dp = new int[nums.length];
        if(nums==null||nums.length<2)
            return res;
        for(int i=0;i<nums.length;i++) {
            for(int j = i-1;j>=0;j--) {
                if(dp[j] == nums[i]) {
                    res[0] = j;
                    res[1] = i;
                    return res;
                }
            }
            dp[i] = target - nums[i];

        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/two-sum
