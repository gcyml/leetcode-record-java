# [Valid Anagram][title]

## Description

Given two strings _s_ and _t_, write a function to determine if _t_ is an anagram of _s_.

**Example 1:**

```
Input: s = "anagram", t = "nagaram"
Output: true
```

**Example 2:**

```
Input: s = "rat", t = "car"
Output: false
```

**Note:**  
You may assume the string contains only lowercase alphabets.

**Follow up:**  
What if the inputs contain unicode characters? How would you adapt your solution to such case?

**Tags:** Hash Table, Sort

**Difficulty:** Easy

## 思路

题意是判断两个字符串是否互为变位词。

这里用了映射表，存储 26 个字母的频数，若两个字符串的频数完全相等，则互为变位词。

``` java
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] array= new int[26];
         for(char c: s.toCharArray()) {
            array[c-'a']++;
        }
        for(char c: t.toCharArray()) {
            array[c-'a']--;
        }
        int res = 0;
        while(res < 26){
            if(array[res++] != 0) {
                return false;
            }
        }
        return true;
    }
}
```

[title]: https://leetcode.com/problems/valid-anagram
