# [Remove Duplicates from Sorted Array][title]

## Description

Given an array of integers where 1 ≤ a[i] ≤ n (*n* = size of array), some elements appear twice and others appear once.

Find all the elements of [1, *n*] inclusive that do not appear in this array.

Could you do it without extra space and in O(*n*) runtime? You may assume the returned list does not count as extra space.

**Example:**

```
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
```

**Tags:** Array

**Difficulty:** Easy

## 思路

题意是给定一个范围在 `1 ≤ a[i] ≤ n` 的数组，找到所有没有出现在数组中的数字。解法是创建一个长度为 `n` 的数组记录元素的出现次数，返回所有未出现的数字。

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] marked = new boolean[nums.length];
        for(int num : nums){
            marked[num-1] = true;
        }
        for(int i=0;i<marked.length;i++) {
            if(!marked[i]) {
                res.add(i+1);
            }
        }
        return res;
    }
}
```


[title]: https://leetcode.com/problems/remove-duplicates-from-sorted-array
