# [Repeated Substring Pattern][title]

## Description

Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

**Example 1:**

```
Input:  "abab"
Output: True
Explanation: It 's the substring "ab" twice.
```

**Example 2:**

```
Input:  "aba"
Output: False
```

**Example 3:**

```
Input:  "abcabcabcabc"
Output: True
Explanation: It 's the substring "abc" four times. (And the substring "abcabc" twice.)
```

**Tags:** String

**Difficulty:** Easy

## 思路

题意是给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。若要满足条件，该子字符串长度必须满足 `1 <= len <= s.length/2`，且长度必须能被字符串的总长度整除。因此遍历找出付出条件的子字符串，逐个判断。判断字符串是否是某个子字符串重复构成，只需要把字符串整分成几份，逐一和子字符串比对即可。

``` java
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() ==1) return false;
        for(int i=1;i<=s.length()/2;i++) {
            if(s.length() % i == 0) {
                if(helper(s, i)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(String s, int n) {
        String templet = s.substring(0, n);
        for(int i=0;i<s.length();i+=n) {
            if(!templet.equals(s.substring(i, i+n))) {
                return false;
            }
        }
        return true;
    }
}
```

[title]: https://leetcode.com/problems/repeated-substring-pattern
