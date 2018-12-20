# [Factorial Trailing Zeroes][title]

## Description

Given an integer _n_ , return the number of trailing zeroes in _n_!.

**Example 1:**

```
Input: 3
Output: 0
Explanation:**  3! = 6, no trailing zero.
```

**Example 2:**

```
Input: 5
Output: 1
Explanation:**  5! = 120, one trailing zero.
```

**Note:** Your solution should be in logarithmic time complexity.

**Tags:** Math

**Difficulty:** Easy

## 思路

题意是求出阶乘结果的尾部 0 个数。解法是考虑 n! 的质数因子。后缀 0 总是由质因子 2 和质因子 5 相乘得来的。如果我们可以计数 2 和 5 的个数，问题就解决了。考虑下面的例子：

1. n = 5: 5! 的质因子中 (2 * 2 * 2 * 3 * 5) 包含一个 5 和三个 2。因而后缀 0 的个数是 1。

2. n = 11: 11! 的质因子中 (2^8 * 3^4 * 5^2 * 7) 包含两个 5 和三个 2。于是后缀 0 的个数就是 2。

质因子中 2 的个数总是大于等于 5 的个数。因此只要计数 5 的个数就可以了。需要注意的是25中有25，20，15，10，5，但是 25 又可以分为 5*5，因此需要判断 t=n/5 后中 t 的 5 个数。

``` java
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n >0){
            count += n/5;
            n /= 5;
        }
        return count;
    }
}
```

[title]: https://leetcode.com/problems/factorial-trailing-zeroes
