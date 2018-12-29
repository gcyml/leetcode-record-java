# [Longest Harmonious Subsequence][title]

## Description

We define a harmonious array is an array where the difference between its
maximum value and its minimum value is **exactly** 1.

Now, given an integer array, you need to find the length of its longest
harmonious subsequence among all its possible
[subsequences](https://en.wikipedia.org/wiki/Subsequence).

**Example 1:**  
        

**Note:** The length of the input array will not exceed 20,000.


**Tags:** Hash Table

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n)+1);
            } else {
                map.put(n, 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(map.containsKey(entry.getKey()+1)) {
                max = Math.max(max, entry.getValue() + map.get(entry.getKey()+1)); 
            }
           
        }
        return max;
        
    }
}
```

[title]: https://leetcode.com/problems/longest-harmonious-subsequence