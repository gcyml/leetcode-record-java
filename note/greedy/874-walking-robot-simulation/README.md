# [Walking Robot Simulation][title]

## Description

A robot on an infinite grid starts at point (0, 0) and faces north. The robot can receive one of three possible types of commands:

* `-2`: turn left 90 degrees
* `-1`: turn right 90 degrees
* `1 <= x <= 9`: move forward `x` units

Some of the grid squares are obstacles.

The `i`-th obstacle is at grid point `(obstacles[i][0], obstacles[i][1])`

If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.)

Return the **square** of the maximum Euclidean distance that the robot will be from the origin.

**Example 1:**

```
Input: commands = [4,-1,3], obstacles = []
Output: 25
Explanation: robot will go to (3, 4)
```

**Example 2:**

```
Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
```

**Note:**

1. `0 <= commands.length <= 10000`
2. `0 <= obstacles.length <= 10000`
3. `-30000 <= obstacle[i][0] <= 30000`
4. `-30000 <= obstacle[i][1] <= 30000`
5. The answer is guaranteed to be less than `2 ^ 31`.

**Tags:** Greedy

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int angle = 0;
        int x = 0, y = 0;
        int max = 0;
        HashSet<Long> obstacleSet = new HashSet<>();
        for (int[] obstacle: obstacles) {
            long ox = (long) obstacle[0];
            long oy = (long) obstacle[1];
            obstacleSet.add((ox << 16) + oy);
        }
        for(int command : commands) {
            if(command == -1) {
                angle = (angle+1)%4;
                switch(command) {
                    case -1:
                        break;
                    case -2:
                        break;
                }
            } else if(command == -2) {
                angle = (angle-1+4)%4;
            } else {
                for(int i=0;i<command;i++) {
                    int nx = x + dir[angle][0];
                    int ny = y + dir[angle][1];
                    long code = (nx << 16) + ny;
                    if(!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        max = Math.max(max, x*x + y*y);
                    }
                }
            }
        }
        return max;
    }
}
```

[title]: https://leetcode.com/problems/walking-robot-simulation
