# [Assign Cookies][title]

## Description

Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor $g_i$, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size $s_j$. If $s_j$ >= $g_i$, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

**Note:**  
You may assume the greed factor is always positive.  
You cannot assign more than one cookie to one child.

**Example 1:**  

```
Input: [1,2,3], [1,1]
    
Output: 1
    
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.
```

**Example 2:**  

```
Input: [1,2], [1,2,3]
    
Output: 2
    
Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.
```  

**Tags:** Greedy

**Difficulty:** Easy

## 思路

要使的结果尽可能优，就得尽可能的让饼干刚好能满足孩子的胃口，没有浪费。

因此，把两个数组排序后，然后线性遍历饼干数组，当饼干尺寸能满足孩子胃口时，把饼干分配给孩子。这样分配出来的结果，饼干浪费是最少的。每分配给一个孩子，孩子数组对应的指针向前移动， 表示该孩子已经被分配给饼干。所有孩子被分配完后，跳出循环。

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
