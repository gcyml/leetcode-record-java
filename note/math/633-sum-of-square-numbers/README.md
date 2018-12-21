# [Sum of Square Numbers][title]

## Description

Given a non-negative integer `c`, your task is to decide whether there're two integers `a` and `b` such that $a^2$ + $b^2$ = c.

**Example 1:**  

```
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
```

**Example 2:**  

```
Input: 3
Output: False
```

**Tags:** Math

**Difficulty:** Easy

## 思路

解题思路是先从数的平方根开始，把平方根强制转换为整型，若转换后值的平方仍等于值`c`，再凑一个 0 就满足了条件。若上一条件不符合，则求出差值 `c - a*a`，判断该差值的平方根是否为整数，若为整数，则已求出 a 和 b，返回 true。

``` java
class Solution {
    public boolean judgeSquareSum(int c) {
        for(int i = (int)Math.sqrt(c); i >= 0;i--) {
            if(i * i == c) {
                return true;
            }
            int d = c - i*i, t = (int)Math.sqrt(d);
            if(t * t == d) {
                return true;
            }
        }
        return false;
    }
}
```

[title]: https://leetcode.com/problems/sum-of-square-numbers
