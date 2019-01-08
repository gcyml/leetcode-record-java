# [Reach a Number][title]

## Description

You are standing at position `0` on an infinite number line. There is a goal at position `target`.

On each move, you can either go left or right. During the _n_ -th move (starting from 1), you take _n_ steps.

Return the minimum number of steps required to reach the destination.

**Example 1:**  

```
Input: target = 3
Output: 2
Explanation:
On the first move we step from 0 to 1.
On the second step we step from 1 to 3.
```

**Example 2:**  

```
Input: target = 2
Output: 3
Explanation:
On the first move we step from 0 to 1.
On the second move we step  from 1 to -1.
On the third move we step from -1 to 2.
```

**Note:**  

* `target` will be a non-zero integer in the range `[-10^9, 10^9]`.

**Tags:** Math

**Difficulty:** Easy

## 思路

设步数为 n，先假设每次移动都往右走，若不能通过只往右走走到 target，再通过其他方法来解决。当移动的位置大于等于 target时，此时差值为 d。

如果 d 是偶数，可以通过把步长为 d/2 的那一步改为向左走，此时一来一回，就可以把差值 d 消掉。 

弱国 d 为奇数，此时是没办法通过改变之前的步数方向来消掉差值的。因此只能通过继续往前走把差值变为偶数，使得可以通过第一种方法消掉差值。

而要往前走几步才能把差值变为偶数，取决于 `n + 1` 的步长是偶数还是奇数。若为奇数，奇数相加变为偶数，则可以通过再加一步达到目的；若为偶数，只能加两步。

``` java
class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0;
        int n   = 0;
        while (sum < target){
            n ++;
            sum += n;
        }
        int res = sum - target;
        if(sum == target || (res & 1) == 0) return n;
        return n + ((n & 1) == 0 ? 1 : 2);
    }
}
```

[title]: https://leetcode.com/problems/reach-a-number
