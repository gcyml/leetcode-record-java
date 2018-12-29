# [Longest Word in Dictionary][title]

## Description

Given a list of strings `words` representing an English Dictionary, find the
longest word in `words` that can be built one character at a time by other
words in `words`. If there is more than one possible answer, return the
longest word with the smallest lexicographical order.

If there is no answer, return the empty string.

**Example 1:**  
        

**Example 2:**  
        

**Note:**

* All the strings in the input will only contain lowercase letters.
* The length of `words` will be in the range `[1, 1000]`.
* The length of `words[i]` will be in the range `[1, 30]`.


**Tags:** Hash Table, Trie

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);  //æåº
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