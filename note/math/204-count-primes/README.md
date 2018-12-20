# [Count Primes][title]

## Description

Count the number of prime numbers less than a non-negative number, **_n_**.

**Example:**

```
Input: 10
Output: 4
Explanation:** There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
```

**Tags:** Hash Table, Math

**Difficulty:** Easy

## 思路

题意是计算小于非负数 n 的素数的数量。这一题用到的是 [埃拉托斯特尼筛法Sieve of Eratosthenes][link]。我们从 2 开始遍历到 n，将其所有的倍数全部标记出来，依次类推，直到根号 n，此时数组中未被标记的数字就是质数。

![算法图示](http://upload.wikimedia.org/wikipedia/commons/b/b9/Sieve_of_Eratosthenes_animation.gif)

``` java
class Solution {
    public int countPrimes(int n) {
        int[] mask = new int[n];
        int count =0;
        for(int i =2;i<n;i++){
            if(mask[i] == 0){
                count++;
                for(int j =2;i*j <n;j++){
                    mask[i*j] = 1;
                }
            }
        }
        return count;
    }
}
```

[link]: http://zh.wikipedia.org/wiki/%E5%9F%83%E6%8B%89%E6%89%98%E6%96%AF%E7%89%B9%E5%B0%BC%E7%AD%9B%E6%B3%95
[title]: https://leetcode.com/problems/count-primes
