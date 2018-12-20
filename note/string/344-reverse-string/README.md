# [Reverse String][title]

## Description

Write a function that takes a string as input and returns the string reversed.

**Example 1:**

```
Input: "hello"
Output: "olleh"
```

**Example 2:**

```
Input: "A man, a plan, a canal: Panama"
Output: "amanaP :lanac a ,nalp a ,nam A"
```

**Tags:** Two Pointers, String

**Difficulty:** Easy

## 思路

题目是翻转字符串，从尾部遍历字符串，构建出新的字符串即可。需要注意，不要用字符串连接，用StringBuilder。因为String是不可变的，每次拼接都会创建一个新的String，多次拼接会浪费大量时间。

``` java
class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>-1;i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
```

[title]: https://leetcode.com/problems/reverse-string
