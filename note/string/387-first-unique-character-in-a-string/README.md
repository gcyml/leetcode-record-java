# [First Unique Character in a String][title]

## Description

Given a string, find the first non-repeating character in it and return it's
index. If it doesn't exist, return -1.

**Examples:**


```
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
```

**Note:** You may assume the string contain only lowercase letters.


**Tags:** Hash Table, String

**Difficulty:** Easy

## 思路

题意是找到字符串的第一个不重复的字符，并返回索引。这里用了两个数组来分别记录26个字母的频数和第一次出现的位置，最后返回频数为1且索引最小的值。

``` java
class Solution {
    public int firstUniqChar(String s) {
        if(s.length() == 0) return -1;
        int[] count = new int[26];
        int[] position = new int[26];
        for(int i=0;i<s.length();i++) {
            int index = s.charAt(i)-'a';
            count[index]++;
            position[index] = i;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<26;i++) {
            if(count[i] == 1) {
                min = Math.min(min, position[i]); 
            }
        }
        if(min == Integer.MAX_VALUE) {
            return -1;
        } else {
            return min;
        }
    }
}
```

[title]: https://leetcode.com/problems/first-unique-character-in-a-string
