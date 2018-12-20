# [Contains Duplicate][title]

## Description

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

**Example 1:**

``
Input: [1,2,3,1]
Output: true

**Example 2:**

```
Input: [1,2,3,4]
Output: false
```

**Example 3:**

```
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
```

**Tags:** Array, Hash Table

**Difficulty:** Easy

## 思路

题意是判断数组是否存在重复的元素，简单方法是使用 `HashSet` 来记录数组，判断其长度是否等于数组长度即可。

``` java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n: nums) {
            set.add(n);
        }
        return set.size() < nums.length;
    }
}
```

[title]: https://leetcode.com/problems/contains-duplicate
