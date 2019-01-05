# [Sum of Two Integers][title]

## Description

Calculate the sum of two integers _a_ and _b_ , but you are **not allowed** to use the operator `+` and `-`.

**Example 1:**

```
Input: a = 1, b = 2
Output: 3
```

**Example 2:**

```
Input: a = -2, b = 3
Output: 1
```

**Tags:** Bit Manipulation

**Difficulty:** Easy

## 思路

题意是不用 `+` 和 `-` 实现两数相加。

这里是用了位操作来实现。首先，若不考虑进位，两数相加等于两数的按位异或。剩下的需要进位的值，可以用两数异或后再加上进位值，即可得到结果。可知，若要进位，两个二进制位上均为 1，则会进位，即按位左移 1。所以，最后进位后得到的结果即为 `(a & b) << 1`。得到两个结果后，再递归调用自身方法相加。

``` java
class Solution {
    public int getSum(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b; // 不带进位的加
        int carry = (a & b) << 1; // 进位后数
        return getSum(sum, carry);
    }
}
```

[title]: https://leetcode.com/problems/sum-of-two-integers
