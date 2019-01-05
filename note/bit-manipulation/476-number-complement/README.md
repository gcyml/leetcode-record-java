# [Number Complement][title]

## Description

Given a positive integer, output its complement number. The complement
strategy is to flip the bits of its binary representation.

**Note:**  

1. The given integer is guaranteed to fit within the range of a 32-bit signed integer.
2. You could assume no leading zero bit in the integer’s binary representation.

**Example 1:**  

```
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
```

**Example 2:**  

```
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
```

**Tags:** Bit Manipulation

**Difficulty:** Easy

## 思路 0

题意是返回正数的补数。

若直接对值取反，前置 0 也会跟着取反。在这里我们只想有效位取反。因此需要算出所有的有效位，全部置 1。让其和取反所得值进行按位与操作，所得结果即为补数。

``` java
class Solution {
    public int findComplement(int num) {
        int n = 0;
        int tmp = num;
        while(num != 0){
            n = (n << 1)+1;
            num = num >>1;
        }
        return ~tmp & n;
    }
}
```

## 思路 1

另外一种思路把每一个有效位取反，相加。

``` java
class Solution {
    public int findComplement(int num) {
        int n = 0;
        int c = 0;
        while(num != 0){
            if((num & 1) == 0) {
                n += 1 << c;
            }
            c++;
            num = num >>1;
        }
        return n;
    }
}
```

[title]: https://leetcode.com/problems/number-complement
