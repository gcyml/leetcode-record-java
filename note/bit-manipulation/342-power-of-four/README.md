# [Power of Four][title]

## Description

Given an integer (signed 32 bits), write a function to check whether it is a
power of 4.

**Example 1:**
        

**Example 2:**
        

**Follow up** : Could you solve it without loops/recursion?


**Tags:** Bit Manipulation

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 1) return true;
        while(num != 0 && num%4 == 0) {
           num /= 4; 
        }
        
        return num == 1;
    }
}
```

[title]: https://leetcode.com/problems/power-of-four