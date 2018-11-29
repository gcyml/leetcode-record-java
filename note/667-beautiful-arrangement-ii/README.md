# [Non-decreasing Array][title]

## Description

Given an array with `n` integers, your task is to check if it could become non-decreasing by modifying at most  `1` element.

We define an array is non-decreasing if `array[i] <= array[i + 1]` holds for every `i` (1 <= i < n).

**Example 1:**

```
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
```

**Example 2:**

```
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
```

**Note:** The n belongs to [1, 10,000].

**Tags:** Array

**Difficulty:** Easy

## 思路

题意是通过修改一个元素使得数组变成非递减数组。解法是遍历数组，若元素小于前一元素，则替换元素，策略有两种：1是替换前一元素变成当前元素，2是当前元素替换成前一元素。这两种策略额采用需要考虑。

这里我们考虑把前面的数字变成当前的数字的情况，当前面的数字再前面没有数字，那么无疑改前面的数字是最好的，不会影响后面。如果前面的数字再前面还有数字，并且要是小于关系，那么改前面这个数字也是对后面没影响的。

我们只要按照这种方法进行数字的修改，直至遍历完成，如果修改次数小于等于1，那么返回true，否则返回false。

```
***4***，2，3

-1，***4***，2，3

2，3，3，***2***，4
```

我们通过分析上面三个例子可以发现，当我们发现后面的数字小于前面的数字产生冲突后，有时候需要修改前面较大的数字(比如前两个例子需要修改4)，有时候却要修改后面较小的那个数字(比如前第三个例子需要修改2)，那么有什么内在规律吗？是有的，判断修改那个数字其实跟再前面一个数的大小有关系，首先如果再前面的数不存在，比如例子1，4前面没有数字了，我们直接修改前面的数字为当前的数字2即可。而当再前面的数字存在，并且小于当前数时，比如例子2，-1小于2，我们还是需要修改前面的数字4为当前数字2；如果再前面的数大于当前数，比如例子3，3大于2，我们需要修改当前数2为前面的数3。这是修改的情况，由于我们只有一次修改的机会，所以用一个变量cnt，初始化为1，修改数字后cnt自减1，当下次再需要修改时，如果cnt已经为0了，直接返回false。遍历结束后返回true，参见代码如下：


``` java
class Solution {
    public boolean checkPossibility(int[] nums) {
        int modifyCount = 0;
        for(int i = 1;i<nums.length && modifyCount <= 1;i++) {
            if(nums[i-1] > nums[i]){
                modifyCount++;
                if(i-2 < 0 || nums[i-2] <= nums[i])
                    nums[i-1] = nums[i];
                else
                    nums[i] = nums[i-1];
            }
        }
        return modifyCount <= 1;
    }
}
```



[title]: https://leetcode.com/problems/non-decreasing-array
