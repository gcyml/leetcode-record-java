# [Assign Cookies][title]

## Description

Assume you are an awesome parent and want to give your children some cookies.
But, you should give each child at most one cookie. Each child i has a greed
factor gi, which is the minimum size of a cookie that the child will be
content with; and each cookie j has a size sj. If sj >= gi, we can assign the
cookie j to the child i, and the child i will be content. Your goal is to
maximize the number of your content children and output the maximum number.

**Note:**  
You may assume the greed factor is always positive.  
You cannot assign more than one cookie to one child.

**Example 1:**  
        

**Example 2:**  
        


**Tags:** Greedy

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(s);
        Arrays.sort(g);
        int index = 0;
        for(int cookie : s) {
            
            if(g[index] <= cookie) {
                count++;
                index++;
                if(index >= g.length) {
                    break;
                }
            }
            
        }
        return count;
    }
}
```

[title]: https://leetcode.com/problems/assign-cookies