# [Heaters][title]

## Description

Winter is coming! Your first job during the contest is to design a standard
heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find
out minimum radius of heaters so that all houses could be covered by those
heaters.

So, your input will be the positions of houses and heaters seperately, and
your expected output will be the minimum radius standard of heaters.

**Note:**  

  1. Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
  2. Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
  3. As long as a house is in the heaters' warm radius range, it can be warmed.
  4. All the heaters follow your radius standard and the warm radius will the same.

**Example 1:**  
        

**Example 2:**  
        


**Tags:** Binary Search

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        for(int house : houses) {
            // æ¾å°è·ç¦»æ¿å­æè¿çä¾æå¨
            int index = Arrays.binarySearch(heaters, house);
             //index<0,åè¯´æå¨headersä¸­æ²¡æè¯¥house,è¿å (-(æå¥ç¹) - 1),ç¬¬ä¸ä¸ªå¤§äºæ­¤é®çåç´ ç´¢å¼
            if(index < 0){
                index = -(index+1); 
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