# [Longest Palindrome][title]

## Description

Given a string which consists of lowercase or uppercase letters, find the
length of the longest palindromes that can be built with those letters.

This is case sensitive, for example `"Aa"` is not considered a palindrome
here.

**Note:**  
Assume the length of given string will not exceed 1,010.

**Example:**
            Input:    "abccccdd"        Output:    7        Explanation:    One longest palindrome that can be built is "dccaccd", whose length is 7.    


**Tags:** Hash Table

**Difficulty:** Easy

## 思路

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
