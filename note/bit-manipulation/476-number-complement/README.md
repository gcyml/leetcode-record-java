# [Number Complement][title]

## Description

Given a positive integer, output its complement number. The complement
strategy is to flip the bits of its binary representation.

**Note:**  

  1. The given integer is guaranteed to fit within the range of a 32-bit signed integer.
  2. You could assume no leading zero bit in the integer’s binary representation.

**Example 1:**  
        

**Example 2:**  
        


**Tags:** Bit Manipulation

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int findComplement(int num) {
        int n = 0;
        int tmp =num;
        while(num != 0){
            n = (n << 1)+1; 
            num = num >>1;
        }
        return ~tmp & n;
    }
}
```

[title]: https://leetcode.com/problems/number-complement