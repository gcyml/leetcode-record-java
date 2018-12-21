# [Perfect Number][title]

## Description

We define the Perfect Number is a **positive** integer that is equal to the
sum of all its **positive** divisors except itself.

Now, given an **integer** n, write a function that returns true when it is a
perfect number and false when it is not.

**Example:**  

```
Input: 28
Output: True
Explanation:** 28 = 1 + 2 + 4 + 7 + 14
```

**Note:** The input number **n** will not exceed 100,000,000. (1e8)

**Tags:** Math

**Difficulty:** Easy

## 思路

题意是判断一个数是否等于它所有的因子总和。一种暴力解法是用映射表，循环遍历。我这里用的是巧妙一些的方式。求出一个因子，必然也可以求出对应的另一个因子，用类似双指针的方式，小数因子不断增大，对应的大数因子随之缩小，直到两个因子相等即 `n = sqrt(num)`。

``` java
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 1;
        for (int i = 2; i * i <= num; ++i) {
            if(num % i == 0) {
                sum += (i + num/i);
            }
            if(i*i == num) {
                sum -= i;
            }
            if(sum > num) return false;
        }
        return sum == num;
    }
}

```

[title]: https://leetcode.com/problems/perfect-number
