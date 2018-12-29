# [Single Number][title]

## Description

Given a **non-empty**  array of integers, every element appears _twice_ except
for one. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it
without using extra memory?

**Example 1:**
            Input: [2,2,1]    Output: 1    

**Example 2:**
            Input: [4,1,2,1,2]    Output: 4    


**Tags:** Hash Table, Bit Manipulation

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int singleNumber(int[] nums) {
        int a=0;
        // å ä¸ºåªæä¸ä¸ªä¸åæ°ï¼æä»¥ç¸åæ°ä¼ç¸äºæµæ¶ï¼åªçå¯ä¸æ°
        for(int i =0; i<nums.length;i++){
            a^=nums[i];
        }
        return a;
    }
}
```

[title]: https://leetcode.com/problems/single-number
