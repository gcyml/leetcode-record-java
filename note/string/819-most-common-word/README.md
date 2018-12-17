# [Most Common Word][title]

## Description

Given a paragraph and a list of banned words, return the most frequent word
that is not in the list of banned words.  It is guaranteed there is at least
one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of
punctuation.  Words in the paragraph are not case sensitive.  The answer is in
lowercase.



**Example:**


```
Input:
paragraph =  "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output:  "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
```



**Note:**

* `1 <= paragraph.length <= 1000`.
* `1 <= banned.length <= 100`.
* `1 <= banned[i].length <= 10`.
* The answer is unique, and written in lowercase (even if its occurrences in `paragraph` may have uppercase symbols, and even if it is a proper noun.)
* `paragraph` only consists of letters, spaces, or the punctuation symbols `!?',;.`
* There are no hyphens or hyphenated words.
* Words only consist of letters, never apostrophes or other punctuation symbols.


**Tags:** String

**Difficulty:** Easy

## 思路

题意是从一个段落中找出除去黑名单中的单词中频数最高的一个，大小写不敏感。这题先用转小写后，分割出单词，然后记录非黑名单中的单词频数，返回频数最高的那个。

``` java
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        String[] words = paragraph.split("[^a-zA-Z]");
        int max = 0;
        String res = "";
        HashMap<String, Integer> count = new HashMap<>();
        HashSet<String> ban = new HashSet<>();
        for(String b: banned) {
            ban.add(b);
        }
        for(String s: words) {
            if(ban.contains(s)) {
                continue;
            }
            if(s.length() == 0) {
                continue;
            }
            if(count.containsKey(s)) {
                count.put(s, count.get(s) +1);
            } else {
                count.put(s, 1);
            }
        }
        for (String s :count.keySet()){
            if(count.get(s) > max) {
                max = count.get(s);
                res = s;
            }
		}
        return res;
    }
}
```

[title]: https://leetcode.com/problems/most-common-word
