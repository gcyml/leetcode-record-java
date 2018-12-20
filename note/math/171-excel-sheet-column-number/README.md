# [Excel Sheet Column Number][title]

## Description

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

```
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
```

**Example 1:**

```
Input:  "A"
Output: 1
```

**Example 2:**

```
Input: "AB"
Output: 28
```

**Example 3:**

```
Input: "ZY"
Output: 701
```

**Tags:** Math

**Difficulty:** Easy

## 思路

题目是 [Excel Sheet Column Title][168-note] 相反，这里是 26 进制转 10 进制。从高位到地位线性遍历，每次遍历进位后累加即可。需要注意的是这里的 `A` 对应的是 1，而不是 0。

``` java
class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for(int i = 0;i < s.length(); i++) {
            res = 26 * res + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/excel-sheet-column-number
[168-note]: https://github.com/gcyml/leetcode-record-java/tree/master/note/math/168-excel-sheet-column-title
