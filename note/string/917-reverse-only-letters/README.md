# [Reverse Only Letters][title]

## Description

Given a string `S`, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

**Example 1:**

```
Input: "ab-cd"
Output: "dc-ba"
```

**Example 2:**

```
Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
```

**Example 3:**

```
Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
```

**Note:**

1. `S.length <= 100`
2. `33 <= S[i].ASCIIcode <= 122`
3. `S` doesn't contain `\` or `"`

**Tags:** String

**Difficulty:** Easy

## 思路

题意是反转字母位置。采用双指针的方法，一个指向首部，一个指向尾部，当两个指针指向均为字母时，则反转两个字母的位置，指针移动。若任一指针指向不为字母，则该指针移动。

``` java
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int left = 0, right=S.length()-1;
        while(left < right){
            if(!isLetter(chars[left])) {
                left++;
                continue;
            }
            if(!isLetter(chars[right])) {
                right--;
                continue;
            }
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
        return new String(chars);
    }
    boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
```

[title]: https://leetcode.com/problems/reverse-only-letters
