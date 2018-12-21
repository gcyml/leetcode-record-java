# [Arranging Coins][title]

## Description

You have a total of _n_ coins that you want to form in a staircase shape,
where every _k_ -th row must have exactly _k_ coins.

Given _n_ , find the total number of **full** staircase rows that can be
formed.

_n_ is a non-negative integer and fits within the range of a 32-bit signed
integer.

**Example 1:**

```
n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
```

**Example 2:**

```
n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
```

**Tags:** Math, Binary Search

**Difficulty:** Easy

## 思路

解法是每上一层都算出剩余的硬币数，若剩余硬币数不超过下一层可放满的硬币数 `k`时，则此时 `k-1` 即为完整阶梯行的总行数。

``` java
class Solution {
    public int arrangeCoins(int n) {
        if(n < 2) {
            return n;
        }
        int k = 1;
        while(n>=k) {
            n -= k++;
        }
        return k-1;
    }
}
```

[title]: https://leetcode.com/problems/arranging-coins
