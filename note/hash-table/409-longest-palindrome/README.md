# [Longest Palindrome][title]

## Description

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example `"Aa"` is not considered a palindrome here.

**Note:**  
Assume the length of given string will not exceed 1,010.

**Example:**

```
Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
```

**Tags:** Hash Table

**Difficulty:** Easy

## 思路

要构建出最长的回文字符串。可知，回文字符串除了中间字符外，其频数均为偶数。所以，记录字符串的字符频数。若频数为偶数，则累加，若为奇数，则 -1 变成偶数再做累加。此时遍历完得到的结果，是由偶数次字符组成的，但若还有多余的字符，还可以加入作为中间字符，其仍然是回文字符串。

``` java
class Solution {
    public int longestPalindrome(String s) {
        int[] array = new int[52];
        int l = 0;
        for(char c: s.toCharArray()) {
            if(c < 'a') {
                array[c-'A']++;
            } else {
                array[c-'a' +26]++;
            }

        }
        for(int i=0;i<52;i++) {
            if(array[i]%2 ==0){
                l+= array[i];
            } else {
                l += array[i] -1;
            }
        }
        if(l<s.length()){
            l++;
        }
        return l;

    }
}
```

[title]: https://leetcode.com/problems/longest-palindrome
