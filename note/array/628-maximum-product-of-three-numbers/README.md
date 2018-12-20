# [Maximum Product of Three Numbers][title]

## Description

Given an integer array, find three numbers whose product is maximum and output the maximum product.

**Example 1:**

```
Input: [1,2,3]
Output: 6
```

**Example 2:**

```
Input: [1,2,3,4]
Output: 24
```

**Note:**

1. The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
2. Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

**Tags:** Array, Math

**Difficulty:** Easy

## 思路

题意是给定一个整数数组，找到三个最大的数字并输出最大乘积。这道题最主要是要考虑正负数的情况。全为正数，数值前三的相乘即可。如果负数的绝对值比较大，我们可以取绝对值最大的两个负数参与相乘，最后比较一下两种算法的乘积哪个大。
第一种方法是先对数组进行快排，时间复杂度是 `O(nlgn)`。

``` java
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3], nums[0] * nums[1] * nums[nums.length-1]);

    }
}
```

第二种效率比较高的方法是线性遍历找出我们所需要的数值正序排序的前两名和后三名。时间复杂度是 `O(n)`。

``` java
class Solution {
  class Solution {
      public int maximumProduct(int[] nums) {
         int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
          for (int n : nums) {
              if (n > max1) {
                  max3 = max2;
                  max2 = max1;
                  max1 = n;
              } else if (n > max2) {
                  max3 = max2;
                  max2 = n;
              } else if (n > max3) {
                  max3 = n;
              }

              if (n < min1) {
                  min2 = min1;
                  min1 = n;
              } else if (n < min2) {
                  min2 = n;
              }
          }
          return Math.max(max1*max2*max3, max1*min1*min2);

      }
  }
```

[title]: https://leetcode.com/problems/maximum-product-of-three-number
