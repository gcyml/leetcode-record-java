# [Self Dividing Numbers][title]

## Description

A _self-dividing number_ is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because `128 % 1 == 0`, `128 % 2 == 0`, and `128 % 8 == 0`.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

**Example 1:**  

```
Input:
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
```

**Note:**

* The boundaries of each input argument are `1 <= left <= right <= 10000`.

**Tags:** Math

**Difficulty:** Easy

## 思路

一个数能被其各位数整除则称为自除数，自除数不包括 0 。题意是给出数值边界，给出其中所有自除数。此题的关键在于自除数的判断。循环求出数值的各位数 `a`， 若 a 为 0 或数值不能被 a 整除则为非自除数。

``` java
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> r = new ArrayList<>();
        for(int i = left;i<=right;i++) {
            int temp = i;
            while(temp!=0){
                int a = temp%10;
                if(a == 0 || i % a != 0) {
                    break;
                }
                temp /= 10;
            }
            if(temp==0)
                r.add(i);
        }
        return r;
    }
}
```

[title]: https://leetcode.com/problems/self-dividing-numbers
