# [Implement strStr()][title]

## Description

Implement [strStr()](http://www.cplusplus.com/reference/cstring/strstr/).

Return the index of the first occurrence of needle in haystack, or **-1** if
needle is not part of haystack.

**Example 1:**

```
Input: haystack =  "hello", needle = "ll"
Output: 2
```

**Example 2:**

```
Input: haystack =  "aaaaa", needle = "bba"
Output: -1
```

**Clarification:**

What should we return when `needle` is an empty string? This is a great
question to ask during an interview.

For the purpose of this problem, we will return 0 when `needle` is an empty
string. This is consistent to C's
[strstr()](http://www.cplusplus.com/reference/cstring/strstr/) and Java's
[indexOf()](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexOf\(java.lang.String\)).

**Tags:** Two Pointers, String

**Difficulty:** Easy

## 思路0

题目是实现C语言中的 `strstr`函数，类似 java 的 `indexOf`。简单暴力的方法自然是自然调用 `indexOf` 方法了。

``` java
class Solution {
    public int strStr(String haystack, String needle) {
         return haystack.indexOf(needle);
    }
}
```

## 思路1

另一种方法是使用双指针的方法，一个指针指向 `haystack`，这里用 `i` 表示，一个指针指向 `needle` 用 `j` 表示。双层遍历，指针 `i` 不断移动，每次移动指针 `j`都从头开始判断 `needle` 是否为 `haystack` 的子字符串。若符合，则 `i` 即是索引位置。

``` java
class Solution {
    public int strStr(String haystack, String needle) {
         for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
              if (j == needle.length()) return i;
              if (i + j == haystack.length()) return -1;
              if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
          }
    }
}
```

[title]: https://leetcode.com/problems/implement-strstr
