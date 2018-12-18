# [Reverse Words in a String III][title]

## Description

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

**Example 1:**


```
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
```

**Note:** In the string, each word is separated by single space and there will not be any extra space in the string.


**Tags:** String

**Difficulty:** Easy

## 思路

题意是反转字符串中的单词。解法是遍历字符串的字符数组，然后用双指针的方法，一个记录单词的初始位置 `left`，一个记录末尾位置 `right`。判断单词结束的标志是空格。得到的单词的位置后，再反转单词的顺序。需要注意的是，由于是碰到空格才认定单词结束，最后一个单词可能不会被记录，需要在遍历完成后反转最后一个单词。

``` java
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<chars.length;i++) {
            if(chars[i] == ' ') {
                right = i-1;
                sb.append(helper(chars, left, right));
                sb.append(" ");
                left = i+1;
            }
        }
        if(left != chars.length) {
            sb.append(helper(chars, left, chars.length-1));
        }
        
        return sb.toString();
    }
    public String helper(char[] chars, int left, int right) {
        StringBuilder sb = new StringBuilder();
        for(int i=right;i>=left;i--) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }
}
```

[title]: https://leetcode.com/problems/reverse-words-in-a-string-iii
