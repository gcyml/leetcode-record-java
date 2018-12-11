# [Monotonic Array][title]

## Description

An array is _monotonic_ if it is either monotone increasing or monotone
decreasing.

An array `A` is monotone increasing if for all `i <= j`, `A[i] <= A[j]`.  An
array `A` is monotone decreasing if for all `i <= j`, `A[i] >= A[j]`.

Return `true` if and only if the given array `A` is monotonic.



**Example 1:**


```
Input: [1,2,2,3]
Output: true
```

**Example 2:**

```
Input: [6,5,4,4]
Output: true
```

**Example 3:**

```
Input: [1,3,2]
Output: false
```

**Example 4:**

```
Input: [1,2,4,5]
Output: true
```

**Example 5:**

```
Input: [1,1,1]
Output: true
```

**Note:**

  1. `1 <= A.length <= 50000`
  2. `-100000 <= A[i] <= 100000`


**Tags:** Array

**Difficulty:** Easy

## 思路

题意是判断数组是否为单调递增或单调递减数列。题目比较简单，先判断第一个元素和第二个元素是递增还是递减，而后判断后面的数列是否符合条件。

``` java
class Solution {
    public boolean isMonotonic(int[] A) {
        int isIncrease = -1;
        for(int i = 0;i<A.length-1;i++){
            if(A[i] < A[i+1]) {
                if(isIncrease == 1) {
                    return false;
                } else if(isIncrease == -1){
                    isIncrease = 0;
                }
            } else if(A[i] > A[i+1]) {
                if(isIncrease == 0) {
                    return false;
                } else if(isIncrease == -1){
                    isIncrease = 1;
                }
            }
        }
        return true;
    }
}
```

[title]: https://leetcode.com/problems/monotonic-array
