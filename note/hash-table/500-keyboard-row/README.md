# [Keyboard Row][title]

## Description

Given a List of words, return the words that can be typed using letters of
**alphabet** on only one row 's of American keyboard like the image below.

![pic](https://assets.leetcode.com/uploads/2018/10/12/keyboard.png)

**Example:**

```
Input: [ "Hello", "Alaska", "Dad", "Peace"]
Output: [ "Alaska", "Dad"]
```

**Note:**

1. You may use one character in the keyboard more than once.
2. You may assume the input string will only contain letters of alphabet.

**Tags:** Hash Table

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                map.put(c, i); //put <char, rowIndex> pair into the map
            }
        }
        List<String> list = new ArrayList<>();
        for(String word: words) {
            char[] letters = word.toUpperCase().toCharArray();
            int index = map.get(letters[0]);
            for(int i =1;i<letters.length;i++){
                if(map.get(letters[i]) != index) {
                    index = -1;
                    break;
                }
            }
            if(index != -1) {
                list.add(word);
            }
        }
        String[] res = new String[list.size()];
        list.toArray(res);
        return res;
    }
}
```

[title]: https://leetcode.com/problems/keyboard-row
