# [Count Primes][title]

## Description

Count the number of prime numbers less than a non-negative number, **_n_**.

**Example:**
            Input: 10    Output: 4    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.    


**Tags:** Hash Table, Math

**Difficulty:** Easy

## 思路

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

[title]: https://leetcode.com/problems/count-primes
