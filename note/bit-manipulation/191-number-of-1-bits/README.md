# [Number of 1 Bits][title]

## Description

Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the [Hamming weight](http://en.wikipedia.org/wiki/Hamming_weight)).

**Example 1:**

```
Input: 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011  has a total of three '1' bits.
```

**Example 2:**

```
Input: 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000  has a total of one '1' bit.
```

**Example 3:**

```
Input: 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one  '1' bits.
```

**Note:**

* Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
* In Java, the compiler represents the signed integers using [2's complement notation](https://en.wikipedia.org/wiki/Two%27s_complement). Therefore, in **Example 3**  above the input represents the signed integer `-3`.

**Follow up** :

If this function is called many times, how would you optimize it?

**Tags:** Bit Manipulation

**Difficulty:** Easy

## 思路 0

题意是给定一个无符号整数，返回其二进制表达式中数字位数为 `1` 的个数。

第一种简单的方法就是循环按位右移判断了。

``` java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for(int i = 0;i<32;i++){
            res += n&1;
            n >>= 1;
        }
        return res;
    }
}
```

## 思路 1

第二种方法比较巧妙，其效率也大大提高，就是应用了 n&(n-1)。n 与 n-1 的区别在于，对于 n，从右向左数的第一个 "1" 开始一直到右，和 n-1，完全相反。每次取按位与运算，即是把 n 的 低位 1 置 0。

``` java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while(n!= 0){
            n = n&(n-1);
            res++;
        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/number-of-1-bits
