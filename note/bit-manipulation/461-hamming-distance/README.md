# [Hamming Distance][title]

## Description

The [Hamming distance](https://en.wikipedia.org/wiki/Hamming_distance) between
two integers is the number of positions at which the corresponding bits are
different.

Given two integers `x` and `y`, calculate the Hamming distance.

**Note:**  
0  ≤ `x`, `y` < 231.

**Example:**
            Input: x = 1, y = 4        Output: 2        Explanation:    1   (0 0 0 1)    4   (0 1 0 0)            ↑   ↑        The above arrows point to positions where the corresponding bits are different.    


**Tags:** Bit Manipulation

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int hammingDistance(int x, int y) {
        int r =0;
        int t = x ^ y;
        while(t >0) {
            if(((t+1) ^ t) !=1)
                r++;
            t >>= 1;
            
        }
        return r;
    }
}
```

[title]: https://leetcode.com/problems/hamming-distance
