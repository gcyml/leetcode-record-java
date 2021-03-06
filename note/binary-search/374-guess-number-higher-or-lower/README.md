# [Guess Number Higher or Lower][title]

## Description

We are playing the Guess Game. The game is as follows:

I pick a number from **1** to **_n_**. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API `guess(int num)` which returns 3 possible results (`-1`, `1`, or `0`):

```
-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
```    

**Example :**

```     
Input: n = 10, pick = 6
Output: 6
```  

**Tags:** Binary Search

**Difficulty:** Easy

## 思路

二分查找实现。

``` java
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int min = 1, max = n;
        while(min <= max) {
            int medium = min +(max-min)/2;
            int result = guess(medium);
            if(result > 0) {
                min = medium+1;
            } else if (result < 0) {
                max = medium-1;
            } else {
                return medium;
            }            
        }
        return min;
    }
}
```

[title]: https://leetcode.com/problems/guess-number-higher-or-lower
