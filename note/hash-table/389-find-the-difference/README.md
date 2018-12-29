# [Find the Difference][title]

## Description

Given two strings **_s_** and **_t_** which consist of only lowercase letters.

String **_t_** is generated by random shuffling string **_s_** and then add
one more letter at a random position.

Find the letter that was added in **_t_**.

**Example:**
        


**Tags:** Hash Table, Bit Manipulation

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public char findTheDifference(String s, String t) {
        int[] array = new int[26];
        for(char c: s.toCharArray()) {
            array[c-'a']++;
        }
        for(char c: t.toCharArray()) {
            array[c-'a']--;
        }
        int res = 0;
        while(array[res] == 0){
            res++;
        }
        return (char)(res+'a');
    }
}
```

[title]: https://leetcode.com/problems/find-the-difference