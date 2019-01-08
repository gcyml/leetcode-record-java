# [First Bad Version][title]

## Description

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have `n` versions `[1, 2, ..., n]` and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API `bool isBadVersion(version)` which will return whether `version` is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

**Example:**

```        
Given n = 5, and version = 4 is the first bad version.
    
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
    
Then 4 is the first bad version. 
```  

**Tags:** Binary Search

**Difficulty:** Easy

## 思路

类似于二分查找，若中间值是错误版本，则说明第一个出错的版本在左侧，若为正确版本，则为右侧。需要注意的是，最后的边界的问题，这里用的是 low < height，而不是 二分查找中的 low <= height。当 low == height 时，此时指向的都为第一个错误版本，返回其中一个即可。

``` java
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n == 1) {
            return 1;
        }
        int low = 1, hight = n;
        while(low < hight){
            int mid = low + (hight-low)/2;
            if(isBadVersion(mid)) {
                hight = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}
```

[title]: https://leetcode.com/problems/first-bad-version
