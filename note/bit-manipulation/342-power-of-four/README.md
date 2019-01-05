# [Power of Four][title]

## Description

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

**Example 1:**

```
Input: 16
Output: true
```

**Example 2:**

```
Input: 5
Output: false
```

**Follow up:** Could you solve it without loops/recursion?

**Tags:** Bit Manipulation

**Difficulty:** Easy

## 思路 0

判断数是否为 4 的幂。

第一种解法是判断该数的质因子是否只由 4 组成。

``` java
class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 1) return true;
        while(num != 0 && num%4 == 0) {
           num /= 4;
        }
        return num == 1;
    }
}
```

## 思路 1

由于题目是属于位操作的分类里，上面并没有用到位操作。所以又想出了一个用到了位操作的解法。下面给出了几个 4 的幂的二进制：

```
1:  0000 0001
4:  0000 0100
16: 0001 0000
64: 1000 0000
```

可以观察得出 4 的幂，在二进制中都只有一个 1，且都是由 1 按位左移两位得到的。根据此规律，遍历所有 4 的幂，若相等则返回 true。

``` java
class Solution {
    public boolean isPowerOfFour(int num) {
        int tmp = 1;
        for(int i = 0; i < 32 && num >= tmp; i++) {
            if(num == tmp) {
                return true;
            }
            tmp <<= 2;
        }
        return false;
    }
}
```

[title]: https://leetcode.com/problems/power-of-four
