# [Heaters][title]

## Description

Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

**Note:**  

1. Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
2. Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
3. As long as a house is in the heaters' warm radius range, it can be warmed.
4. All the heaters follow your radius standard and the warm radius will the same.

**Example 1:**  

```    
Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
```

**Example 2:**  

```
Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
```

**Tags:** Binary Search

**Difficulty:** Easy

## 思路

先将取暖器数组排序，在遍历所有 house，对每个 house，在取暖器数组中进行 binary search，如果命中，则说明取暖器位置和 house 位置重合，这个 house 的最小半径为 0；如果没有命中，则使用返回的 index，将 index 左边和右边的取暖器坐标与 house 坐标求差值，找出这个 house 最小半径。说白了，也是在查找 house 的最近左右取暖器。

这里是用了 java 的 Arrays.binarySearch 方法来实现二分查找，注意它的返回值有两种结果：

1. 如果找到关键字，则返回值为关键字在数组中的位置索引，且索引从 0开始
2. 如果没有找到关键字，返回值为负的插入点值，所谓插入点值就是第一个比关键字大的元素在数组中的位置索引，而且这个位置索引从 1 开始。

``` java
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        for(int house : houses) {
            // 找到距离房子最近的供暖器
            int index = Arrays.binarySearch(heaters, house);
             //index<0,则说明在 headers 中没有该 house,返回 (-(插入点) - 1),第一个大于此键的元素索引
            if(index < 0){
                index = ~index; 
                int distL = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int distR = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
                res = Math.max(res, Math.min(distL, distR));
            }
           
            
        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/heaters
