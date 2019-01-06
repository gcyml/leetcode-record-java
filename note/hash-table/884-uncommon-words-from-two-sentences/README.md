# [Uncommon Words from Two Sentences][title]

## Description

We are given two sentences `A` and `B`.  (A _sentence_  is a string of space separated words.  Each _word_ consists only of lowercase letters.)

A word is _uncommon_  if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words.

You may return the list in any order.

**Example 1:**

```
Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]
```

**Example 2:**

```
Input: A = "apple apple", B = "banana"
Output: ["banana"]
```

**Note:**

1. `0 <= A.length <= 200`
2. `0 <= B.length <= 200`
3. `A` and `B` both contain only spaces and lowercase letters.

**Tags:** Hash Table

**Difficulty:** Easy

## 思路

不常见词，其实就是在所有 A 和 B 的词频总和中只有一次的单词，理解了这一点问题就迎刃而解了。

用映射表把两个句子的词频累加在一起，找出映射表中词频为一的单词，添加到列表中。

``` java
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] array1 = A.split(" ");
        String[] array2 = B.split(" ");
        for(String word: array1) {
            if(map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            } else{
                map.put(word, 1);
            }
        }
        for(String word: array2) {
            if(map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            } else{
                map.put(word, 1);
            }
        }
        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        String[] array = new String[list.size()];
        list.toArray(array);
        return array;
    }
}
```

[title]: https://leetcode.com/problems/uncommon-words-from-two-sentences
