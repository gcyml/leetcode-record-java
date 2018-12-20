# [Detect Capital][title]

## Description

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the
following cases holds:

1. All letters in this word are capitals, like "USA".
2. All letters in this word are not capitals, like "leetcode".
3. Only the first letter in this word is capital if it has more than one letter, like "Google".

Otherwise, we define that this word doesn't use capitals in a right way.

**Example 1:**

```
Input: "USA"
Output: True
```

**Example 2:**

```
Input: "FlaG"
Output: False
```

**Note:** The input will be a non-empty word consisting of uppercase and
lowercase latin letters.

**Tags:** String

**Difficulty:** Easy

## 思路

题意是判断单词拼写格式是否正确。遍历记录大写字母个数，同时判断是否全为大写字母，或全为小写字母，或首字母大写，不符合条件则返回 `false`。遍历结束说明单词格式无错误，返回 `true`。

``` java
class Solution {
    public boolean detectCapitalUse(String word) {
        int capitalCount = 0;
        for(int i=0;i<word.length();i++) {
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                capitalCount++;
            }
            if(capitalCount != i+1 && capitalCount != 0 && !(capitalCount == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')) {
                return false;
            }
        }
        return true;
    }
}
```

[title]: https://leetcode.com/problems/detect-capital
