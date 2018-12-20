# [Add Digits][title]

## Description

Given a non-negative integer `num`, repeatedly add all its digits until the result has only one digit.

**Example:**

```
Input: 38
Output: 2
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
             Since 2 has only one digit, return it.
```

**Follow up:**  
Could you do it without any loop/recursion in O(1) runtime?

**Tags:** Math

**Difficulty:** Easy

## 思路

题意是重复把一个数的各位相加，直到变成个位数数字。解法照着题目写即可。

``` java
class Solution {
    public int addDigits(int num) {
        while(num >= 10) {
            int tmp = num;
            num = 0;
            while(tmp != 0) {
                num += tmp%10;
                tmp /= 10;
            }
        }
        return num;
    }
}
```

[title]: https://leetcode.com/problems/add-digits
