# [Prime Number of Set Bits in Binary Representation][title]

## Description

Given two integers `L` and `R`, find the count of numbers in the range `[L,
R]` (inclusive) having a prime number of set bits in their binary
representation.

(Recall that the number of set bits an integer has is the number of `1`s
present when written in binary. For example, `21` written in binary is `10101`
which has 3 set bits. Also, 1 is not a prime.)

**Example 1:**  
        

**Example 2:**  
        

**Note:**  

  1. `L, R` will be integers `L <= R` in the range `[1, 10^6]`.
  2. `R - L` will be at most 10000.


**Tags:** Bit Manipulation

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for(int i = L;i<=R;i++){
            int n = i;
            int setBitNum = 0;
            while(n != 0) {
                if(n%2 != 0) {
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