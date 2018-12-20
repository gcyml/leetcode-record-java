# [Add Strings][title]

## Description

Given two non-negative integers `num1` and `num2` represented as string, return the sum of `num1` and `num2`.

**Note:**

1. The length of both `num1` and `num2` is < 5100.
2. Both `num1` and `num2` contains only digits `0-9`.
3. Both `num1` and `num2` does not contain any leading zero.
4. You **must not use any built-in BigInteger library** or **convert the inputs to integer** directly.

**Tags:** Math

**Difficulty:** Easy

## 思路

题意是给出两个数的字符串，相加后同样表达为字符串。解法是先判断大数，创建一个比大数长度多一位（防止进位）的数组，同时用 `isCarry` 做进位标记。从低位到高位循环遍历两个值的各位数，相加,若有进位则再加 1，判断总和是否进位，写入到`isCarry`，`sum % 10` 写入到数组中，若遍历超出小数范围，则用 0 代替。遍历完成后，还需要判断进位，以决定是否进行进位加操作。

``` java
class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int maxLen = Math.max(len1, len2);
        char[] str = new char[maxLen+1];
        boolean isCarry = false;
        for(int i = 0; i<maxLen;i++) {
            int a = 0, b = 0;
            if(i < len1) {
                a = num1.charAt(len1-1-i) - '0';
            }
            if(i < len2) {
                b = num2.charAt(len2-1-i) - '0';
            }
            int sum = a+b;
            if(isCarry) {
                sum++;
            }
            isCarry = sum>9?true:false;
            str[str.length-i-1] = (char)(sum%10 + '0');
        }
        if(isCarry) {
            str[0] = '1';
        } else {
            str[0] = ' ';
        }
        return String.valueOf(str).trim();
    }
}
```

[title]: https://leetcode.com/problems/add-strings
