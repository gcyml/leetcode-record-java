# [Binary Number with Alternating Bits][title]

## Description

Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

**Example 1:**  

```
Input: 5
Output: True
Explanation:
The binary representation of 5 is: 101
```

**Example 2:**  

```
Input: 7
Output: False
Explanation:
The binary representation of 7 is: 111.
```

**Example 3:**  

```
Input: 11
Output: False
Explanation:
The binary representation of 11 is: 1011.
```

**Example 4:**  

```
Input: 10
Output: True
Explanation:
The binary representation of 10 is: 1010.
```

**Tags:** Bit Manipulation

**Difficulty:** Easy

## 思路

给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。

解法是循环取出每一位的值，和前一位做比较，若相等则为 false。

``` java
class Solution {
    public boolean hasAlternatingBits(int n) {
        int lastBit = n & 1;
        n >>= 1;
        while(n != 0) {
            if((n & 1) == lastBit) {
                return false;
            }
            lastBit = n & 1;
            n >>= 1;
        }
        return true;
    }
}
```

[title]: https://leetcode.com/problems/binary-number-with-alternating-bits
