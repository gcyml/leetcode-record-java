# [Sort Array By Parity II][title]

## Description

Given an array `A` of non-negative integers, half of the integers in A are
odd, and half of the integers are even.

Sort the array so that whenever `A[i]` is odd, `i` is odd; and whenever `A[i]`
is even, `i` is even.

You may return any answer array that satisfies this condition.



**Example 1:**

```
Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
```

**Note:**

  1. `2 <= A.length <= 20000`
  2. `A.length % 2 == 0`
  3. `0 <= A[i] <= 1000`


**Tags:** Array,Sort

**Difficulty:** Easy

## 思路

题意是对数组进行排序，以便每当 A[i] 为奇数时，i 为奇数;
只要 A[i] 是偶数，i 为偶数。解法是用两个数记录奇数索引和偶数索引，若数值为偶数，则把该数写入到偶数索引的元素中。

``` java
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] B = new int[A.length];
        int odd = 0;
        int even = 1;
        for(int t: A){
            if(t%2 == 0){
                B[odd] = t;
                odd+=2;
            }else{
                B[even] = t;
                even+=2;
            }
        }
        return B;
    }
}
```

[title]: https://leetcode.com/problems/sort-array-by-parity-ii
