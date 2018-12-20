# [Nth Digit][title]

## Description

Find the _n_ th digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

**Note:**  
_n_ is positive and will fit within the range of a 32-bit signed integer ( _n_ < 231).

**Example 1:**

```
Input:
3

Output:
3
```

**Example 2:**

```
Input:
11

Output:
0

Explanation:**
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
```

**Tags:** Math

**Difficulty:** Easy

## 思路

要找到对应的数字，首先得找出该数字所在的数值。可以发现序列存在一定的规律，一位数时，从 1 到 9 有 9 个。二位数时，从 10 到 99 有 90 个，依次类推。由此，可以得到数值是几位数，且数值在区间的第几位。用 `start` 表示数值区间开始的数，`len` 表示该区间数值长度，`cnt` 表示区间数。

设 `n` 为 11，此时 `n` 大于一位数区间的个数范围即 9。n 减去 9，则得到该数字在下一区间距离开始的距离，也就是距离二位数区间（10, 11, 12, 13, ... 99）的开始处两个数字。由于这个距离小于二位数区间的个数也就是 2 * 90 = 180个，因此它必定在二位数区间。

当 n 落到某一个确定的区间里了，那么 (n-1)/len 就是目标数字在该区间里的坐标，加上 start 就是得到了目标数字，然后我们将目标数字 start 转为字符串，(n-1)%len 就是所要求的目标位

``` java
class Solution {
    public int findNthDigit(int n) {
        int len = 1, start = 1;
        long cnt = 9;
        while(n > len * cnt) {
            n -= len * cnt;
            len++;
            start *= 10;
            cnt *= 10;
        }
        start += (n-1) / len;
        return String.valueOf(start).charAt((n-1)%len) - '0';
    }
}
```

[title]: https://leetcode.com/problems/nth-digit
