# [Find All Anagrams in a String][title]

## Description

Given a string **s** and a **non-empty** string **p** , find all the start
indices of **p** 's anagrams in **s**.

Strings consists of lowercase English letters only and the length of both
strings **s** and **p** will not be larger than 20,100.

The order of output does not matter.

**Example 1:**
        

**Example 2:**
        


**Tags:** Hash Table

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] letters = new int[26];
        List<Integer> res = new ArrayList<>();
        for(char c : p.toCharArray()) {
            letters[c-'a']++;
        }
        for(int i =0;i<=(s.length()-p.length());i++){
            String subStr = s.substring(i, p.length()+i);
            if(p.equals(subStr) || isAnagram(subStr, letters)) {
                res.add(i);
            }
        }
        return res;
    }
    boolean isAnagram(String s, int[] letters) {
        int[] myLetters = new int[26];
        for(char c : s.toCharArray()) {
            myLetters[c-'a']++;
        }
        for(int i = 0;i<26;i++) {
            if(myLetters[i] != letters[i]) {
                return false;
            }
        }
        return true;
    }
}
```

[title]: https://leetcode.com/problems/find-all-anagrams-in-a-string