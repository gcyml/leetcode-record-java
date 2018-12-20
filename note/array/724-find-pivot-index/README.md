# [Find Pivot Index][title]

## Description

Given an array of integers `nums`, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

**Example 1:**

```
Input:
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation:
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.
```

**Example 2:**

```
Input:
nums = [1, 2, 3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.
```

**Note:**

1. The length of `nums` will be in the range `[0, 10000]`.
2. Each element `nums[i]` will be an integer in the range `[-1000, 1000]`.

**Tags:** Array

**Difficulty:** Easy

## 思路

题意是找到数组中的某个元素，其左侧所有元素相加的和等于右侧所有元素相加的和。解法就是先找算出所有元素总和得到 `sum`。而后再次线性遍历，判断 `sum - nums[i]` 是否等于左侧元素的总和的2倍。

``` java
class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length < 3) return -1;
        int sum = 0, curSum = 0;
        for(int n :nums){
            sum += n;
        }
        for(int i =0;i<nums.length;i++) {
            if(sum - nums[i] == curSum *2) {
                return i;
            }
            curSum += nums[i];

        }

        return -1;
    }
}
```

[title]: https://leetcode.com/problems/find-pivot-index
