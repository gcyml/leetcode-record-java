# [Power of Three][title]

## Description

Given an integer, write a function to determine if it is a power of three.

**Example 1:**

```
Input: 27
Output: true
```

**Example 2:**

```
Input: 0
Output: false
```

**Example 3:**

```
Input: 9
Output: true
```

**Example 4:**

```
Input: 45
Output: false
```

**Follow up:**  
Could you do it without using any loop / recursion?

**Tags:** Math

**Difficulty:** Easy

## 思路

题意是判断一个数是否为 3 的倍数。题目和 [Power of Two][note-231] 相似，解法一样，不再赘述。

``` java
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) {
            return false;
        }
        while(n > 1) {
            if(n%3 == 0) {
                n /= 3;
            } else {
                return false;
            }
        }
        return true;
    }
}
```

[note-231]: https://github.com/gcyml/leetcode-record-java/tree/master/note/math/231-power-of-two
[title]: https://leetcode.com/problems/power-of-three
