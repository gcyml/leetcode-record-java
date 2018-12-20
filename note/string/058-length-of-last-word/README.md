# [Length of Last Word][title]

## Description

Given a string _s_ consists of upper/lower-case alphabets and empty space
characters `' '`, return the length of last word in the string.

If the last word does not exist, return 0.

**Note:** A word is defined as a character sequence consists of non-space
characters only.

**Example:**

```
Input: "Hello World"
Output: 5
```

**Tags:** String

**Difficulty:** Easy

## 思路

题意是返回最后一个单词的长度。既然是最后一个单词，自然从尾部遍历记录单词长度，若碰到空格则跳出即可。需要注意的特殊情况是尾部存在空格。

``` java
class Solution {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int num = 0;
        for(int i = len-1;i>=0;i--) {
            if(chars[i] != ' ') {
                num++;
            } else if(num != 0) break;
        }
        return num;
    }
}
```

[title]: https://leetcode.com/problems/length-of-last-word
