# [Number of Boomerangs][title]

## Description

Given _n_ points in the plane that are all pairwise distinct, a "boomerang" is
a tuple of points `(i, j, k)` such that the distance between `i` and `j`
equals the distance between `i` and `k` ( **the order of the tuple matters**
).

Find the number of boomerangs. You may assume that _n_ will be at most **500**
and coordinates of points are all in the range **[-10000, 10000]**
(inclusive).

**Example:**  
            Input:    [[0,0],[1,0],[2,0]]        Output:    2        Explanation:    The two boomerangs are **[[1,0],[0,0],[2,0]]** and **[[1,0],[2,0],[0,0]]**    


**Tags:** Hash Table

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0; 
        
        for(int i = 0;i< points.length;i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            for(int j = 0;j< points.length;j++) {
                if(i!= j) {
                    double d = distance(points[i], points[j]);
                    if(map.containsKey(d)) {
                        map.put(d, map.get(d)+1);
                    } else {
                         map.put(d, 1);
                    }
                }
            }
            for (Integer value : map.values()) { 
                if(value > 1) {
                    res += value * (value-1);
                }
            }
        }
        return res;
    }
    double distance(int[] p1, int[] p2) {
        return Math.pow(p2[1] - p1[1], 2) + Math.pow(p2[0] - p1[0], 2);
    }
}
```

[title]: https://leetcode.com/problems/number-of-boomerangs
