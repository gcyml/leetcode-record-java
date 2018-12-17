# [Rotated Digits][title]

## Description

X is a good number if after rotating each digit individually by 180 degrees,
we get a valid number that is different from X.  Each digit must be rotated -
we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8
rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each
other, and the rest of the numbers do not rotate to any other number and
become invalid.

Now given a positive number `N`, how many numbers X from `1` to `N` are good?



**Example:**

```
Input: 10
Output: 4
Explanation:
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
```

**Note:**

* N  will be in range `[1, 10000]`.


**Tags:** String

**Difficulty:** Easy

## 思路

本题难度在于判断一个数是否为好数。从好数的定义可知，若数中包含 `3`、`4`、`7` 必然不为好数，若数字全部由 `0`、`4`、`8` 组成，其旋转后得到的结果为自身，也不符合好数的定义。

``` java
class Solution {
    public int rotatedDigits(int N) {
        int res= 0;
        for(int i=1;i<=N;i++) {
            if(helper(i)) {
                res++;
            }
        }
        return res;
    }
    public boolean helper(int n) {
        int selfCount = 0;
        int count = 0;
        while(n != 0) {
            int tmp = n%10;
            if(tmp == 3 || tmp ==4 || tmp == 7) {
                return false;
            } else if(tmp == 0 || tmp ==1 || tmp == 8){
                selfCount++;
            }
            n /= 10;
            count++;
        }
        return selfCount != count;
    }
}
```

[title]: https://leetcode.com/problems/rotated-digits
