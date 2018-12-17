# [Valid Palindrome][title]

## Description

Given a string, determine if it is a palindrome, considering only alphanumeric
characters and ignoring cases.

**Note:**  For the purpose of this problem, we define empty string as valid
palindrome.

**Example 1:**


```
Input:  "A man, a plan, a canal: Panama"
Output: true
```

**Example 2:**


```
Input:  "race a car"
Output: false
```


**Tags:** Two Pointers, String

**Difficulty:** Easy

## 思路

题意是判断字符串是否为回文，只考虑数字和字母，忽略大小写。验证回文很简单，首尾字符验证相等即可。这里在于需要对字符串进行处理，转换成小写，过滤出数字和字母。

``` java
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
           if(c >= 'a' && c <= 'z') {
                sb.append(c);
            } 
            if(c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        s = sb.toString();
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

[title]: https://leetcode.com/problems/valid-palindrome
