# [Palindrome Number][title]

## Description

Determine whether an integer is a palindrome. An integer is a palindrome when
it reads the same backward as forward.

**Example 1:**

```
Input: 121
Output: true
```

**Example 2:**

```
Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
```

**Example 3:**

```
Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
```

**Follow up:**

Coud you solve it without converting the integer to a string?

**Tags:** Math

**Difficulty:** Easy

## 思路

题意是判断数值是否为回文数。把数值反转后，判断两值是否相等即可。

``` java
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int rev = 0;
        int tmp = x;
        while(x > 0) {
            rev = rev*10 + x%10;
            x /= 10;
        }
        return rev == tmp;
    }
}
```

[title]: https://leetcode.com/problems/palindrome-number
