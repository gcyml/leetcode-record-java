# [Nim Game][title]

## Description

You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones.
The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

**Example:**

```
Input: 4
Output: false 
Explanation: If there are 4 stones in the heap, then you will never win the game;
                 No matter 1, 2, or 3 stones you remove, the last stone will always be 
                 removed by your friend.
```

**Tags:** Brainteaser

**Difficulty:** Easy

## 思路

作为先手保证稳赢，就必须保证如例子中，在最后两轮时，留给对方的石头数为 4。要保证做到这一步，就得在先手后保证剩余的石头数为 4 的倍数。此后，每一轮和对方拿掉的石头数总和为4，最后两轮，留给对方的石头必然为 4 个。所以关键在于先手能不能让剩余石头数变为 4 的 倍数，即石头总数不能被 4 整除。

``` java
class Solution {
    public boolean canWinNim(int n) {
        return n%4 !=0;
    }
}
```

[title]: https://leetcode.com/problems/nim-game
