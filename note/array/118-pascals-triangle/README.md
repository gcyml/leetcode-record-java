# [Two Sum II - Input array is sorted][title]

## Description

Given a non-negative integer *numRows*, generate the first *numRows* of Pascal's triangle.

![img](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

In Pascal's triangle, each number is the sum of the two numbers directly above it.

**Example:**

```
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

**Tags:** Array

**Difficulty:** Easy

## 思路

题意是给出行数，输出帕斯卡尔三角形，很简单的模拟，就不多说了。

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for(int i =0;i<numRows;i++) {
            row.add(1);
            for(int j =1;j<=i;j++) {
                if(j == i) {
                    row.add(1);
                }else {
                    row.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
                }
            }
            res.add(row);
        }
        return res;
    }
}
```


[title]: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
