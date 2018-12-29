# [Sum of Two Integers][title]

## Description

Calculate the sum of two integers _a_ and _b_ , but you are **not allowed** to
use the operator `+` and `-`.

**Example 1:**
            Input: a = 1, b = 2    Output: 3    

**Example 2:**
            Input: a = -2, b = 3    Output: 1    


**Tags:** Bit Manipulation

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int getSum(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b; // ä¸å¸¦è¿ä½çå 
        int carry = (a & b) << 1; // è¿ä½åæ°
        return getSum(sum, carry);
    }
}
```

[title]: https://leetcode.com/problems/sum-of-two-integers
