# [Sqrt(x)][title]

## Description

Implement `int sqrt(int x)`.

Compute and return the square root of _x_ , where  _x_  is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

**Example 1:**

```
Input: 4
Output: 2
```

**Example 2:**

```
Input: 8
Output: 2
Explanation:** The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
```

**Tags:** Math, Binary Search

**Difficulty:** Easy

## 思路

题意是求平方根，结果为整数。最先想到的办法就是找出所有候选值的平法，和 `x` 比较大小。为了缩短查找时间，我们采用二分搜索法来找平方根，时间复杂度是 `O(logN)`。

``` java
class Solution {
    public int mySqrt(int x) {
        if (x == 0)
        return 0;
        int left = 1, right = x;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                ans = mid;  
                left = mid + 1;
            }
        }
        return ans ;
    }
}
```

[title]: https://leetcode.com/problems/sqrtx
