# [Majority Element][title]

## Description

Given an array of size n, find the majority element. The majority element is the element that appears **more than** `⌊ n/2 ⌋` times.

You may assume that the array is non-empty and the majority element always exist in the array.

**Example 1:**

```
Input: [3,2,3]
Output: 3
```

**Example 2:**

```
Input: [2,2,1,1,1,2,2]
Output: 2
```

**Tags:** Array, Divide and Conquer, Bit Manipulation

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n)+1);
            } else {
                map.put(n, 1);
            }
        }
        int max = 0, res = 0;
        for (int key : map.keySet()) {
             if(map.get(key) > max) {
                max = map.get(key);
                res = key;
            }
        }
        return res;
    }
}
```

``` java
class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int compare_num = nums[0];
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == compare_num) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                compare_num = nums[i];
                count = 1;
            }

        }
        return compare_num;
    }
}
```

[title]: https://leetcode.com/problems/majority-element
