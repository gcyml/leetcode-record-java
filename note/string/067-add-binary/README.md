# [Add Binary][title]

## Description

Given two binary strings, return their sum (also a binary string).

The input strings are both **non-empty** and contains only characters `1` or
`0`.

**Example 1:**

```
Input: a =  "11", b = "1"
Output:  "100"
```

**Example 2:**

```
Input: a =  "1010", b = "1011"
Output:  "10101"
```

**Tags:** Math, String

**Difficulty:** Easy

## 思路

题意是对两个二进制字符串做加法运算。

解题思路是先找出两个字符串的最高位，对两个字符串从低位开始按位相加，遍历到最高位结束，无法取出值的按 0 处理。

遍历时，取出两个字符串对应位的值，加上进位值 `add` 得到 sum。sum 有四种结果：0、1、2、3。针对不同结果，做出处理。遍历完成后，还需要清空进位。

``` java
class Solution {
    public String addBinary(String a, String b) {
        String result ="";
        int la = a.length();
        int lb = b.length();
        if (la == 0) { return b; }
        if (lb == 0) { return a; }
        int lmax = Math.max(la, lb);
        int add = 0;
        for (int i = 0; i < lmax; i++) {
            char ca = la > i ? a.charAt(la-i-1) : '0';
            char cb = lb > i ? b.charAt(lb-i-1) : '0';
            int sum = add + cb + ca - 96;
            if(sum % 2 == 0) {
                result = '0' + result;
                add = sum / 2;
            } else{
                result = '1' + result;
                add = sum > 2 ? 1 : 0;
            }
        }
        if(add == 1) {
            result = '1' + result;
        }
        return result;
    }
}
```

[title]: https://leetcode.com/problems/add-binary
