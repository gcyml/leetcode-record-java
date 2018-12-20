# [Ugly Number][title]

## Description

Write a program to check whether a given number is an ugly number.

Ugly numbers are **positive numbers** whose prime factors only include `2, 3, 5`.

**Example 1:**

```
Input: 6
Output: true
Explanation:** 6 = 2 × 3
```

**Example 2:**

```
Input: 8
Output: true
Explanation:** 8 = 2 × 2 × 2
```

**Example 3:**

```
Input: 14
Output: false
Explanation:**14 is not ugly since it includes another prime factor 7.
```

**Note:**

1. `1` is typically treated as an ugly number.
2. Input is within the 32-bit signed integer range: [−231,  231 − 1].

**Tags:** Math

**Difficulty:** Easy

## 思路

题意是判断一个数是否为丑数，即正整数的质数因子只有 2 和 3 和 5。 解法是若能被 `2, 3, 5` 整除，则 num 等于 整除后的商，否则不符合条件，不为丑数。循环整除直到 num 小于等于 1。

``` java
class Solution {
    public boolean isUgly(int num) {
        if(num <= 0) return false;
        while(num > 1) {
            if(num%2 == 0) {
                num /= 2;
            } else if(num%3 == 0) {
                num /= 3;
            } else if (num%5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }

}
```

[title]: https://leetcode.com/problems/ugly-number
