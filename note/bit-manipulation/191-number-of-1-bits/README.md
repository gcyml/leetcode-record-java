# [Number of 1 Bits][title]

## Description

Write a function that takes an unsigned integer and return the number of '1'
bits it has (also known as the [Hamming
weight](http://en.wikipedia.org/wiki/Hamming_weight)).



**Example 1:**
        

**Example 2:**
        

**Example 3:**
        



**Note:**

  * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
  * In Java, the compiler represents the signed integers using [2's complement notation](https://en.wikipedia.org/wiki/Two%27s_complement). Therefore, in **Example 3**  above the input represents the signed integer `-3`.



**Follow up** :

If this function is called many times, how would you optimize it?


**Tags:** Bit Manipulation

**Difficulty:** Easy

## 思路

``` java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while(n!= 0){
            n = n&(n-1);
            res++;
        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/number-of-1-bits