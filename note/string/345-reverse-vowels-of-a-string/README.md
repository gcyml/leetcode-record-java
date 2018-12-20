# [Reverse Vowels of a String][title]

## Description

Write a function that takes a string as input and reverse only the vowels of a
string.

**Example 1:**

```
Input:** "hello"
Output:** "holle"
```

**Example 2:**

```
Input:** "leetcode"
Output:** "leotcede"
```

**Note:**
The vowels does not include the letter  "y".

**Tags:** Two Pointers, String

**Difficulty:** Easy

## 思路

题意是翻转字符串中的元音字符。a、e、i、o、u 五个字符就是元音字符。这里用到的解法是双指针，left 和 right 分别从字符串头和尾开始，若两个指针指向的字符都为元音字符时，则交换字符，两个指针移动。相反，则不是元音的指针需要移动。

``` java
class Solution {
    public String reverseVowels(String s) {
        int left = 0, right = s.length()-1;
        char[] letters = s.toCharArray();
        while(left<right){ 
            boolean leftFlag = isVowel(letters[left]);
            boolean rightFlag = isVowel(letters[right]);
            if(leftFlag && !rightFlag) {
                right--;
            }else if(!leftFlag && rightFlag) {
                left++;
            } else {
                if(isVowel(letters[left]) && isVowel(letters[right])) {
                    char tmp = letters[left];
                    letters[left] = letters[right];
                    letters[right] = tmp;
                }
                right--;
                left++;
            } 
        }
        return String.valueOf(letters);
    }
    public boolean isVowel(char c) {
        if(c >= 'A' && c <= 'Z') {
            c += 'a' -'A';
        }
        switch(c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
        }
        return false;
    }
}
```

[title]: https://leetcode.com/problems/reverse-vowels-of-a-string
