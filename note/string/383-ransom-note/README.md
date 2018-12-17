# [Ransom Note][title]

## Description

Given an arbitrary ransom note string and another string containing letters
from all the magazines, write a function that will return true if the ransom
note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

**Note:**
You may assume that both strings contain only lowercase letters.

```
canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
```

**Tags:** String

**Difficulty:** Easy

## 思路

题意是给出字符串 `ransom` 和 `magazine`， `ransom` 能否由 `magazine`中的字符组成。题目很简单，只要理解了题意就可以了，要使得 `ransom` 的字符在 `magezine` 中全部出现，就得保证后者的字母频数大于等于前者。

``` java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letterCount = new int[26];
        for(char c:ransomNote.toCharArray()) {
            letterCount[c-'a']++;

        }
        for(char c:magazine.toCharArray()) {
            letterCount[c-'a']--;
        }
        for(int i: letterCount) {
            if(i>0) {
                return false;
            }
        }

        return true;
    }
}
```

[title]: https://leetcode.com/problems/ransom-note
