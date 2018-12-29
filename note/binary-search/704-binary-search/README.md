# [Binary Search][title]

## Description

Given a **sorted** (in ascending order) integer array `nums` of `n` elements
and a `target` value, write a function to search `target` in `nums`. If
`target` exists, then return its index, otherwise return `-1`.

  
**Example 1:**
        

**Example 2:**
        



**Note:**

  1. You may assume that all elements in `nums` are unique.
  2. `n` will be in the range `[1, 10000]`.
  3. The value of each element in `nums` will be in the range `[-9999, 9999]`.


**Tags:** Binary Search

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int search(int[] nums, int target) {
        int low = 0, hight = nums.length-1;
        while(low <= hight) {
            int mid = (low + hight)/2;
            if(target > nums[mid]) {
                low = mid+1;
            } else if(target < nums[mid]){
                hight = mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
```

[title]: https://leetcode.com/problems/binary-search