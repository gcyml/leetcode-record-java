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

## 思路0

题意是从数组中找出现次数超过一半的元素，即求众数。开始想到的方法是使用键值对记录出现次数。但是这方法用时22ms，仅仅击败了28%。

``` java
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n)+1);
                if(map.get(n) > nums.length/2) {
                    return n;
                }
            } else {
                map.put(n, 1);
            }
        }
        return nums[0];
    }
}
```

## 思路1

这个方法是从网上看到的，运行只用了3ms，击败了100%的用户。原理是众数和所有其他元素次数抵消后，仍然大于0。用 `count` 表示若和 `compareNum` 相等则 `count`自增，否则自减，若 `count`小于0则必然不是众数。

``` java
class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int compareNum = nums[0];
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == compareNum) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                compareNum = nums[i];
                count = 1;
            }

        }
        return compareNum;
    }
}
```

[title]: https://leetcode.com/problems/majority-element
