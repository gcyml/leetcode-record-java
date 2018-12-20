# [Reverse Integer][title]

## Description

Given a 32-bit signed integer, reverse digits of an integer.

**Example 1:**

```
Input: 123
Output: 321
```

**Example 2:**

```
Input: -123
Output: -321
```

**Example 3:**

```
Input: 120
Output: 21
```

**Note:**  
Assume we are dealing with an environment which could only store integers
within the 32-bit signed integer range: [ −231,  231 − 1]. For the purpose of
this problem, assume that your function returns 0 when the reversed integer
overflows.

**Tags:** Math

**Difficulty:** Easy

## 思路

题目是反转数值。为了防止反转后溢出，反转后的结果用 long 存入，若得到结果超出 int 范围，则返回 0。

``` java
class Solution {
    public int reverse(int x) {
        long tmp = x;
        // 防止结果溢出
        long result = 0;

        while (tmp != 0) {
            result = result * 10 + tmp % 10;
            tmp = tmp / 10;
        }

        // 溢出判断
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            result = 0;
        }

        return (int) result;
    }
}
```

[title]: https://leetcode.com/problems/reverse-integer
