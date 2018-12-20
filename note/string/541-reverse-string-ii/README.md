# [Reverse String II][title]

## Description

Given a string and an integer k, you need to reverse the first k characters
for every 2k characters counting from the start of the string. If there are
less than k characters left, reverse all of them. If there are less than 2k
but greater than or equal to k characters, then reverse the first k characters
and left the other as original.

**Example:**

```
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
```

**Restrictions:** **

1. The string consists of lower English letters only.
2. Length of the given string and k will in the range [1, 10000]

**Tags:** String

**Difficulty:** Easy

## 思路

题意是给定一个字符串和整数 `k`，每 2k 个字符反转前 k 个字符。若剩余不足 k 个字符，则全部反转。若剩余字符数小于 2k，大于 k，则反转前 k 个字符。解法是先反转第一种情况，即 2k 个字符反转前 k 个字符，线性遍历，索引 `i` 每次移动 2k，反转前 k 个字符。即 (i-2k, i-k-1) 之间的字符。遍历完成后，反转剩余的字符。前面遍历完成后，`i` 必然超长数组长度，若超出的长度大于 `k`，则剩余字符数小于 k。

``` java
class Solution {
    public String reverseStr(String s, int k) {
        char[] letters = s.toCharArray();
        int i = 2*k;
        for(;i<letters.length;i+= 2*k) {
            helper(letters, i-(2*k), i-k-1);
        }
        if(i-letters.length > k) {
            helper(letters, i-(2*k), letters.length-1);
        } else {
            helper(letters, i-(2*k), i-k-1);
        }
        return String.valueOf(letters);
    }
    public void helper(char[] letters, int left, int right) {
        while(left < right) {
            char tmp = letters[left];
            letters[left] = letters[right];
            letters[right] = tmp;
            left++;
            right--;
        }
    }
}
```

[title]: https://leetcode.com/problems/reverse-string-ii
