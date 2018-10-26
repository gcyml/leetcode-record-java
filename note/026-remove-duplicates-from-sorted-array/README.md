# [Remove Duplicates from Sorted Array][title]

## Description

Given a sorted array *nums*, remove the duplicates [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) such that each element appear only *once* and return the new length.

Do not allocate extra space for another array, you must do this by **modifying the input array [in-place](https://en.wikipedia.org/wiki/In-place_algorithm)** with O(1) extra memory.

**Example 1:**

```
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
```

**Example 2:**

```
Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
```

**Clarification:**

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by **reference**, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

```
// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
```

**Tags:** Array, Two Pointers

**Difficulty:** Easy

## 思路

题意是让你从一个有序的数组中移除重复的元素，并返回之后数组的长度。解题思路是记录去重后数组长度 `len`, 遍历比较与上一数值是否相等，若不等，则 把`nums[i]`追加到到去重后的数组中，`len` 自增。

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int dup = nums[0];
        int end = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i]!=dup){
                nums[end] = nums[i];
                dup = nums[i];
                end++;
            }
        }
        return end;
    }
}
```


[title]: https://leetcode.com/problems/remove-duplicates-from-sorted-array
