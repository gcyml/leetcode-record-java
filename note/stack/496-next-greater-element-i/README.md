# [Next Greater Element I][title]

## Description

You are given two arrays **(without duplicates)** `nums1` and `nums2` where
`nums1`’s elements are subset of `nums2`. Find all the next greater numbers
for `nums1`'s elements in the corresponding places of `nums2`.

The Next Greater Number of a number **x** in `nums1` is the first greater
number to its right in `nums2`. If it does not exist, output -1 for this
number.

**Example 1:**  
        

**Example 2:**  
        

**Note:**  

  1. All elements in `nums1` and `nums2` are unique.
  2. The length of both `nums1` and `nums2` would not exceed 1000.


**Tags:** Stack

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int num : nums2) {
            while (!st.empty() && st.peek() < num) {
                map.put(st.pop(), num);
            }
            st.push(num);
        }
        for(int i =0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])) {
                 res[i] = map.get(nums1[i]);
            } else {
                res[i] = -1;               
            }
        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/next-greater-element-i