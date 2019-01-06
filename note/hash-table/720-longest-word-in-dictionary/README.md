# [Longest Word in Dictionary][title]

## Description

Given a list of strings `words` representing an English Dictionary, find the longest word in `words` that can be built one character at a time by other words in `words`. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.

**Example 1:**  

```
Input:
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation:
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
```

**Example 2:**  

```
Input:
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation:
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
```

**Note:**

* All the strings in the input will only contain lowercase letters.
* The length of `words` will be in the range `[1, 1000]`.
* The length of `words[i]` will be in the range `[1, 30]`.

**Tags:** Hash Table, Trie

**Difficulty:** Easy

## 思路

由于是单词依次添加的，所以把单词按长度排序后，找出正确的添加方式，把所有符合模式的单词存入 HashSet 中。排序后，若当前单词中减去最后一个字符后得到的单词存在于 HashSet 中，则证明当前单词符合，存入 HashSet 中，且当前单词可能是最长的单词。若当前单词长度超过了之前最长的单词，则更新 res，否则则为同一长度，且出现序在后面，优先级不高。

``` java
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<String>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || set.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                set.add(w);
            }
        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/longest-word-in-dictionary
