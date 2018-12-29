# [Binary Number with Alternating Bits][title]

## Description

Given a positive integer, check whether it has alternating bits: namely, if
two adjacent bits will always have different values.

**Example 1:**  
        

**Example 2:**  
        

**Example 3:**  
        

**Example 4:**  
        


**Tags:** Bit Manipulation

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public boolean hasAlternatingBits(int n) {
        int lastBit = n%2;
        n >>= 1;
        while(n != 0) {
            if(n%2 == lastBit) {
                return false;
            } else {
                lastBit = n%2;
            }
            n >>= 1;
        }
        return true;
    }
}
```

[title]: https://leetcode.com/problems/binary-number-with-alternating-bits