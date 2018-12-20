# [Goat Latin][title]

## Description

A sentence `S` is given, composed of words separated by spaces. Each word
consists of lowercase and uppercase letters only.

We would like to convert the sentence to " _Goat Latin "_ (a made-up language
similar to Pig Latin.)

The rules of Goat Latin are as follows:

* If a word begins with a vowel (a, e, i, o, or u), append `"ma"` to the end of the word.For example, the word 'apple' becomes 'applema'.
* If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add `"ma"`.For example, the word `"goat"` becomes `"oatgma"`.
* Add one letter `'a'` to the end of each word per its word index in the sentence, starting with 1.For example, the first word gets `"a"` added to the end, the second word gets `"aa"` added to the end and so on.

Return the final sentence representing the conversion from `S` to Goat Latin.

**Example 1:**

```
Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
```

**Example 2:**

```
Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
```

Notes:

* `S` contains only uppercase, lowercase and spaces. Exactly one space between each word.
* `1 <= S.length <= 150`.

**Tags:** String

**Difficulty:** Easy

## 思路

题目还是比较简单的，先用 `split` 方法拆分出单词，然后判断根据题目中的判断元音辅音，加入后缀，再根据单词数加入几个 `a` 即可。

``` java
class Solution {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        String count = "a";
        for(int i = 0;i<words.length;i++) {
            char firstLetter = words[i].toLowerCase().charAt(0);
            if(isVowel(firstLetter)) {
                sb.append(words[i]);
            } else {
                sb.append(words[i].substring(1));
                sb.append(words[i].charAt(0));
            }
            sb.append("ma");
            sb.append(count);
            count += "a";
            sb.append(' ');
        }
        return sb.toString().trim();
    }
    boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
```

[title]: https://leetcode.com/problems/goat-latin
