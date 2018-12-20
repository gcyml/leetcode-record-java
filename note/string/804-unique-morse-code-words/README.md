# [Unique Morse Code Words][title]

## Description

International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: `"a"` maps to `".-"`, `"b"` maps to `"-..."`, `"c"` maps to `"-.-."`, and so on.

For convenience, the full table for the 26 letters of the English alphabet is
given below:

```
[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
```

Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." \+ "-..." \+ ".-"). We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

**Example:**

```
Input: words = [ "gin", "zen", "gig", "msg"]
Output: 2
Explanation:
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".0
```

**Note:**

* The length of `words` will be at most `100`.
* Each `words[i]` will have length in range `[1, 12]`.
* `words[i]` will only consist of lowercase letters.

**Tags:** String

**Difficulty:** Easy

## 思路

用 `hashset` 存入所有摩斯密码翻译结果，得到的长度即是唯一翻译的长度。

``` java
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String morseCodeList[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}; 
        HashSet <String> set = new HashSet<>();
        for(String word : words) {
            StringBuilder m = new StringBuilder();
            for(char letter : word.toCharArray()) {
                m.append(morseCodeList[letter-'a']);
            }
            String str = m.toString();
            set.add(m.toString());
        }
        return set.size();
    }
}
```

[title]: https://leetcode.com/problems/unique-morse-code-words
