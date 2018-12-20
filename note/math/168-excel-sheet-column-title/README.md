# [Excel Sheet Column Title][title]

## Description

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

```
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
```

**Example 1:**

```
Input: 1
Output:  "A"
```

**Example 2:**

```
Input: 28
Output:  "AB"
```

**Example 3:**

```
Input: 701
Output:  "ZY"
```

**Tags:** Math

**Difficulty:** Easy

## 思路

题意是给定一个数，返回其对应的 excel 列标题。excel 列标题是用 26 个字母表达类似 26 进制的东西。所以题目就变成了进制转换。

``` java
class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while(n != 0) {
            n--;
            char letter = (char)(n %26 + 'A');
            res = letter + res;
            n /= 26;
        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/excel-sheet-column-title
