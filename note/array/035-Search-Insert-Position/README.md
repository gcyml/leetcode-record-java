# [Search Insert Position][title]

## Description

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

**Example 1:**

```
Input: [1,3,5,6], 5
Output: 2
```

**Example 2:**

```
Input: [1,3,5,6], 2
Output: 1
```

**Example 3:**

```
Input: [1,3,5,6], 7
Output: 4
```

**Example 4:**

```
Input: [1,3,5,6], 0
Output: 0
```

**Tags:** Array, Binary Search

**Difficulty:** Easy

## 思路0

题意是给出一个排序数组以及值 `target`，返回 `target` 所在位置的索引，所数组中不存在该值，则返回 `target` 插入数组后的索引位置。此题比较简单，遍历即可解决，时间复杂度为 `O(n)`。

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i;
        for(i=0;i<nums.length;i++) {
            if(target <= nums[i])
                return i;
        }
        return i;
    }
}
```

## 思路1
由于给定数组为排序数组，也可以用效率更高的二分搜索的方法来完成，此方法时间复杂度为 `O(log2n)`。

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int middle = (low + high) / 2;
            if(target > nums[middle]) {
                low = middle + 1;
            } else if(target < nums[middle]) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return low;
    }
}
```


[title]: https://leetcode.com/problems/search-insert-position
