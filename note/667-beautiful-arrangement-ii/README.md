# [Beautiful Arrangement II][title]

## Description

Given an array with `n` integers, your task is to check if it could become non-decreasing by modifying at most  `1` element.

We define an array is non-decreasing if `array[i] <= array[i + 1]` holds for every `i` (1 <= i < n).

**Example 1:**

```
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
```

**Example 2:**

```
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
```

**Note:** The n belongs to [1, 10,000].

**Tags:** Array

**Difficulty:** Medium

## 思路


``` java
class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int left = 1, right = n;
        for(int i = 0; left <= right; i++) {
            //从最大和最小数轮流取值
            res[i] = k > 1 ? (k-- % 2 == 0 ? right-- : left++) : left++;  
        }
        return res;
    }
}
```



[title]:https://leetcode.com/problems/beautiful-arrangement-ii
