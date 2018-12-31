# [Next Greater Element I][title]

## Description

You are given two arrays **(without duplicates)** `nums1` and `nums2` where `nums1`’s elements are subset of `nums2`. Find all the next greater numbers for `nums1`'s elements in the corresponding places of `nums2`.

The Next Greater Number of a number **x** in `nums1` is the first greater number to its right in `nums2`. If it does not exist, output -1 for this number.

**Example 1:**  

```
Input: **nums1** = [4,1,2], **nums2** = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
```

**Example 2:**  

```
Input: **nums1** = [2,4], **nums2** = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
```

**Note:**  

1. All elements in `nums1` and `nums2` are unique.
2. The length of both `nums1` and `nums2` would not exceed 1000.

**Tags:** Stack

**Difficulty:** Easy

## 思路

用映射表和栈找出 num2 每个对象右侧比它大的第一个元素。从而也找出了 nums1 的下一个比它大的值。
栈中存储的是未找到对应值的数，映射表中存储的是数和对应的右侧第一个比它大的值。遍历 nums2，把栈中所有小于当前值 `num` 的对象弹出，并写入到映射表中。

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
