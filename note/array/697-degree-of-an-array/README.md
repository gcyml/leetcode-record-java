# [Degree of an Array][title]

## Description

Given a non-empty array of non-negative integers `nums`, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of `nums`, that has the same degree as `nums`.

**Example 1:**

```
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
```

**Example 2:**

```
Input: [1,2,2,3,1,4,2]
Output: 6
```

**Note:**

1. `nums.length` will be between 1 and 50,000.
2. `nums[i]` will be an integer between 0 and 49,999.

**Tags:** Array

**Difficulty:** Easy

## 思路0

``` java
class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int degree = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++) {
            int num = nums[i];
            if(map.containsKey(num)) {
                map.put(num, map.get(num)+1);

            } else {
                map.put(num, 1);
            }
            if(map.get(num) > degree) {
                degree = map.get(num);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == degree){
                int j = nums.length - 1;
                while(nums[j] != nums[i]){
                    j--;
                }
                if(j == i){
                    if(degree == 1){
                        return 1;    
                    }else{
                        continue;
                    }

                }
                int dis = j - i + 1;
                if(dis < min) min = dis;
                map.put(nums[i], 0);
            }
        }
        return min;
    }
}
```

## 思路1

另一种思路是不用映射，用大数组来记录数值出现的次数。一般在提示中写明了数组元素的取值范围，多数都可以用这种解法，用空间换时间。

``` java
class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] sor = new int[50000];
        int max = -1;
        for(int i = 0; i < nums.length; i++){
            sor[nums[i]]++;
            if(sor[nums[i]] > max){
                max = sor[nums[i]];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(sor[nums[i]] == max){
                int j = nums.length - 1;
                while(nums[j] != nums[i]){
                    j--;
                }
                if(j == i){
                    if(max == 1){
                        return 1;    
                    }else{
                        continue;
                    }
                }
                int dis = j - i + 1;
                if(dis < min) min = dis;
                sor[nums[i]] = 0;
            }
        }
        return min;

    }
}
```



[title]: https://leetcode.com/problems/longest-continuous-increasing-subsequence
