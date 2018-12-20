# [Long Pressed Name][title]

## Description

Your friend is typing his `name` into a keyboard.  Sometimes, when typing a
character `c`, the key might get _long pressed_ , and the character will be
typed 1 or more times.

You examine the `typed` characters of the keyboard.  Return `True` if it is
possible that it was your friends name, with some characters (possibly none)
being long pressed.

**Example 1:**

```
Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
```

**Example 2:**

```
Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
```

**Example 3:**

```
Input: name = "leelee", typed = "lleeelee"
Output: true
```

**Example 4:**

```
Input:** name = "laiden", typed = "laiden"
Output:** true
Explanation:** It's not necessary to long press any character.
```

**Note:**

1. `name.length <= 1000`
2. `typed.length <= 1000`
3. The characters of `name` and `typed` are lowercase letters.

**Tags:** Two Pointers, String

**Difficulty:** Easy

## 思路

题意是给出两个字符串 `name` 和 `typed`，判断 `typed` 是否是 `name` 出现错误连续输入同一字符的现象。用双指针法解决，每次指向 `name` 的字符和指向 `typed` 的字符相同时，此时说明该字符是有效字符，则两个指针都要移动。反之，则只移动 `typed` 的指针。

``` java
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int a = 0, b = 0;
        while(b < typed.length() && a < name.length()) {
            if(name.charAt(a) == typed.charAt(b)) {
                a++;
            }
            b++;
        }
        return a == name.length();
    }
}
```

[title]: https://leetcode.com/problems/long-pressed-name
