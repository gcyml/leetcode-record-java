# [Valid Perfect Square][title]

## Description

Given a positive integer _num_ , write a function which returns True if _num_ is a perfect square else False.

**Note:** **Do not** use any built-in library function such as `sqrt`.

**Example 1:**

```
Input: 16
Output: true
```

**Example 2:**

```
Input: 14
Output: false
```

**Tags:** Math, Binary Search

**Difficulty:** Easy

## 思路 0

题意是判断一个数是否为完全平方数。从 1 搜索到 sqrt(num)，看有没有平方正好等于 num 的数。

``` java
class Solution {
    public boolean isPerfectSquare(int num) {
        for (int i = 1; i <= num / i; ++i) {
            if (i * i == num) return true;
        }
        return false;
    }
}
```

## 思路 1

第二种解法是二分查找法。要查找的数为 mid * mid。

``` java
class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 0, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2, t = mid * mid;
            if (t == num) return true;
            else if (t < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
```

[title]: https://leetcode.com/problems/valid-perfect-square
