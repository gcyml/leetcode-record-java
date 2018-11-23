# [Remove Duplicates from Sorted Array][title]

## Description

Given a **non-empty** array of integers, return the **third** maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

**Example 1:**

```
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
```

**Example 2:**

```
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
```

**Example 3:**

```
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
```

**Tags:** Array

**Difficulty:** Easy

## 思路

题意是找出数组中第三大的数。创建三个变量 `max`、 `second` 和 `third`，遍历找出对应的值，返回 `third`。

```java
class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for(int num : nums) {
            if(num > max) {
                third = second;
                second = max;
                max = num;
            } else if(num > second && num < max) {
                third = second;
                second = num;
            } else if(num > third && num < second) {
               third = num;
            }
        }
        return third == Long.MIN_VALUE ? (int)max : (int)third;
    }
}
```


[title]: https://leetcode.com/problems/remove-duplicates-from-sorted-array
