# [Power of Two][title]

## Description

Given an integer, write a function to determine if it is a power of two.

**Example 1:**

```
Input: 1
Output: true
Explanation:** 20 = 1
```

**Example 2:**

```
Input: 16
Output: true
Explanation:** 24 = 16
```

**Example 3:**

```
Input: 218
Output: false
```

**Tags:** Math, Bit Manipulation

**Difficulty:** Easy

## 思路

题意是判断一个数是否为 2 的倍数。题目很简单，n 循环除以 2，若所得结果不能被 2 整除，则 n 说明不是 2 的倍数。

``` java
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        while(n > 1) {
            if(n%2 == 0) {
                n /= 2;
            } else {
                return false;
            }
        }
        return true;
    }
}
```

[title]: https://leetcode.com/problems/power-of-two
