# [Happy Number][title]

## Description

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

**Example:**

```
Input: 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 02 = 1
```

**Tags:** Hash Table, Math

**Difficulty:** Easy

## 思路

题意是编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

解法是用 hashset 来记录平方和，循环记录其各位数上平方和，若得到 1，则返回 true。若平方和开始重发，则说明陷入循环了，返回 false。

``` java
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        while(!hs.contains(n)) {
            hs.add(n);
            if(n == 1) return true;
            int tmp = 0;
            while(n != 0){
                tmp += Math.pow(n%10, 2);
                n /= 10;
            }
            n = tmp;
        }
        return false;
    }
}
```

[title]: https://leetcode.com/problems/happy-number
