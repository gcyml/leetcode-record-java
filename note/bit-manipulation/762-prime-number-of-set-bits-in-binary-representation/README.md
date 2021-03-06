# [Prime Number of Set Bits in Binary Representation][title]

## Description

Given two integers `L` and `R`, find the count of numbers in the range `[L, R]` (inclusive) having a prime number of set bits in their binary
representation.

(Recall that the number of set bits an integer has is the number of `1`s
present when written in binary. For example, `21` written in binary is `10101` which has 3 set bits. Also, 1 is not a prime.)

**Example 1:**  

```
Input: L = 6, R = 10
Output: 4
Explanation:
6 -> 110 (2 set bits, 2 is prime)
7 -> 111 (3 set bits, 3 is prime)
9 -> 1001 (2 set bits , 2 is prime)
10->1010 (2 set bits , 2 is prime)
```

**Example 2:**  

```
Input: L = 10, R = 15
Output: 5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
```

**Note:**  

1. `L, R` will be integers `L <= R` in the range `[1, 10^6]`.
2. `R - L` will be at most 10000.

**Tags:** Bit Manipulation

**Difficulty:** Easy

## 思路

解法是遍历得到值的 1 个数，然后判断个数值是否为质数。这里判断质数用了个巧方法，由于 L 和 R 不超过 10^6，因此最能只能有 20位。把 1 到 20 内所有的质数排列出来，遍历即可。

``` java
class Solution {
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for(int i = L;i<=R;i++){
            int n = i;
            int setBitNum = 0;
            while(n != 0) {
                if((n & 1) != 0) {
                    setBitNum++;
                }
                n >>= 1;
            }
            if(isPrime(setBitNum)) {
                res++;
            }
        }
        return res;
    }
    boolean isPrime(int n){
        int[] primes = {2,3,5,7,11,13,17,19};
        for(int prime: primes) {
            if(n == prime) {
                return true;
            }
        }
        return false;
    }
}
```

[title]: https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation
