# [Valid Palindrome II][title]

## Description

Given a non-empty string `s`, you may delete **at most** one character. Judge whether you can make it a palindrome.

**Example 1:**


```
Input: "aba"
Output: True
```

**Example 2:**


```
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
```

**Note:**

1. The string will only contain lowercase characters a-z. The maximum length of the string is 50000.


**Tags:** String

**Difficulty:** Easy

## 思路

题意是给定一个字符串，你至多可以去掉一个字符，判断是否可以变成回文。先用常规判断回文的双指针法，找出可能多余的字符。当两个指针指向的字符不一致时，则说明两个指针中有一个可能是多余的字符。此时，需要判断哪个才是多余的字符。下面举了两个例子中：

1. abcddcvba
2. abvcddcba

例 1 中，多余的字符在右侧，由于前面已经验证过，left 的左侧和 right 的右侧字符是镜像相等的，余下需要的回文即是 `cddc`,即需要继续验证 `(left, right-1)` 范围的字符串是否为回文；而例 2 中多余的字符在左侧，则需要继续验证的是 `(left+1，right)`。

``` java
class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                 return isPalindrome(s.substring(left+1, right+1)) || isPalindrome(s.substring(left, right));
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```

[title]: https://leetcode.com/problems/valid-palindrome-ii
