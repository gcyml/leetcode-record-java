# [Intersection of Two Arrays II][title]

## Description

Given two arrays, write a function to compute their intersection.

**Example 1:**

```
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
```

**Example 2:**

```
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
```

**Note:**

* Each element in the result should appear as many times as it shows in both arrays.
* The result can be in any order.

**Follow up:**

* What if the given array is already sorted? How would you optimize your algorithm?
* What if _nums1_ 's size is small compared to _nums2_ 's size? Which algorithm is better?
* What if elements of _nums2_ are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

**Tags:** Hash Table, Two Pointers, Binary Search, Sort

**Difficulty:** Easy

## 思路

题意是找出两个数组的集。

这里用到了双指针法，先对两个数组做快排，然后用双指针来比较两个数组中的元素。

``` java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> set = new ArrayList<Integer>();
        for(int i=0,j=0;i < nums1.length && j < nums2.length;) {
            if(nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] res = new int[set.size()];
        int index = 0;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            res[index++] = it.next();

        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/intersection-of-two-arrays-ii
