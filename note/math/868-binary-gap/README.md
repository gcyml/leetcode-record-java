# [Binary Gap][title]

## Description

Given a positive integer `N`, find and return the longest distance between two consecutive 1's in the binary representation of `N`.

If there aren't two consecutive 1's, return 0.

**Example 1:**

```
Input: 22
Output: 2
Explanation:
22 in binary is 0b10110.
In the binary representation of 22, there are three ones, and two consecutive pairs of 1 's.
The first consecutive pair of 1's have distance 2.
The second consecutive pair of 1's have distance 1.
The answer is the largest of these two distances, which is 2.
```

**Example 2:**

```
Input: 5
Output: 2
Explanation:
5 in binary is 0b101.
```

**Example 3:**

```
Input: 6
Output: 1
Explanation:
6 in binary is 0b110.
```

**Example 4:**

```
Input: 8
Output: 0
Explanation:
8 in binary is 0b1000.
There aren 't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
```

**Note:**

* `1 <= N <= 10^9`

**Tags:** Math

**Difficulty:** Easy

## 思路

题意是给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。解法是要遍历 N 的每个二进制位，创建两个变量，需要存入当前的位置 `curIndex`，以及上一个 1 的位置 `lastOne`（初始化为 -1，若为 -1 则说明尚未遍历到有 1 存在）。若当前位为 1，由创建的两个变量得到距离，并更新 `max` 值以及 `lastOne`。

``` java
class Solution {
    public int binaryGap(int N) {
        int cmp = 1;
        int curIndex = 0, dist = 0, lastOne = -1, res = 0;
        while(cmp <= N) {
            if((cmp & N) != 0) {
                dist = lastOne != -1?curIndex-lastOne:0;
                lastOne = curIndex;
                res = Math.max(dist, res);
            }
            cmp = cmp << 1;
            curIndex++;
        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/binary-gap
