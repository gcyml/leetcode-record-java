# [Robot Return to Origin][title]

## Description

There is a robot starting at position (0, 0), the origin, on a 2D plane. Given
a sequence of its moves, judge if this robot **ends up at (0, 0)** after it
completes its moves.

The move sequence is represented by a string, and the character moves[i]
represents its ith move. Valid moves are R (right), L (left), U (up), and D
(down). If the robot returns to the origin after it finishes all of its moves,
return true. Otherwise, return false.

**Note** : The way that the robot is "facing" is irrelevant. "R" will always
make the robot move to the right once, "L" will always make it move left, etc.
Also, assume that the magnitude of the robot's movement is the same for each
move.

**Example 1:**

```
Input:  "UD"
Output: true
Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
```

**Example 2:**

```
Input:  "LL"
Output: false
Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
```

**Tags:** String

**Difficulty:** Easy

## 思路

题意是判断机器人上下左右一顿操作后，是否能回到原点。首先，要回到原点，必然步数是偶数。而后，用 x 和 y 来记录机器人的位置，若干次移动后，若 xy 坐标为原点坐标，则回到原点。

``` java
class Solution {
    public boolean judgeCircle(String moves) {
        char[] steps = moves.toCharArray();
        int x = 0;
        int y = 0;
        if(steps.length%2 != 0) {
            return false;
        }
        for(char step: steps) {
            if('U' == step) {
                y -=1;
            } else if('D' == step) {
                y+=1;
            }else if('L' ==step) {
                x+=1;
            }else if('R' == step) {
                x-=1;
            }
        }
        return x == 0 && y==0;
    }
}
```

[title]: https://leetcode.com/problems/robot-return-to-origin
