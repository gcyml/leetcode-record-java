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

题意是对讲过二进制字符串做加法运算。解题思路就是两个字符串从低位开始按位相加，遍历到最大数高位结束，无法取出按 0 处理。同时记录进位 `add`，把两值和进位相加，若。。

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
            char ca = la>i?a.charAt(la-i-1):'0';
            char cb = lb>i?b.charAt(lb-i-1):'0';
            int sum = add+cb+ca-96;
            if(sum%2==0) {
                result = '0' +result;
                add =sum/ 2;
            } else{
                result = '1' +result;
                add = sum>2?1:0;
            }
        }
        if(add==1) {
            result = '1' +result;
        }
            
        return result;
    }        
}
```

[title]: https://leetcode.com/problems/add-binary
