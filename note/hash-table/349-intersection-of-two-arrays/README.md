# [Intersection of Two Arrays][title]

## Description

Given two arrays, write a function to compute their intersection.

**Example 1:**
        

**Example 2:**
        

**Note:**

  * Each element in the result must be unique.
  * The result can be in any order.




**Tags:** Hash Table, Two Pointers, Binary Search, Sort

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for(int num : nums1) {
            set.add(num);
        }
        for(int num : nums2) {
            if(set.contains(num)) {
                ans.add(num);
                // set.remove
            }
        }
        //éålistæä¸ºæ°ç»è¿å
        int[] a = new int[ans.size()];
        int index = 0;
        Iterator<Integer> i= ans.iterator();
        while(i.hasNext()){
            a[index++] = (int)i.next();
        }

        return a;
    }
}
```

[title]: https://leetcode.com/problems/intersection-of-two-arrays