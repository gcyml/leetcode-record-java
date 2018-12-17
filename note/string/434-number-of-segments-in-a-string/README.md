# [Number of Segments in a String][title]

## Description

Count the number of segments in a string, where a segment is defined to be a
contiguous sequence of non-space characters.

Please note that the string does not contain any **non-printable** characters.

**Example:**


```
Input: "Hello, my name is John"
Output: 5
```


**Tags:** String

**Difficulty:** Easy

## 思路

统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。解法按题目给出的逻辑来做即可，创建一个连续字符标志位 `isContiguous`，做线性遍历，若字符等于空格，若标志位为真，则说明前面是一个单词，res++，最后重置标志位为 `false`。若字符不为空格，则置标志位为 `true`。需要注意一个特殊情况就是，字符串的最后如果没有空格，会导致没有计入最后一个单词。我在这里用的是遍历到 `s.length()`，在此处来记最后一个单词。

``` java
class Solution {
    public int countSegments(String s) {
        int res = 0;
        boolean isContiguous = false;
        for(int i =0;i<=s.length();i++){
            if(i<s.length() && s.charAt(i) != ' ') {
                isContiguous = true;
            } else {
                if(isContiguous) {
                    res++;
                }
                isContiguous = false;
            }
        }

        return res;
    }
}

```

[title]: https://leetcode.com/problems/number-of-segments-in-a-string
