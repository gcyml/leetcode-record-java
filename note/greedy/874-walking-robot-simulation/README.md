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

这题的难点在有两点：

第一个难点是，多次转向后，现在所处方向的判定。用 `[0, 1, 2, 3]` 代表 北、东、西、南四个方向。假设当前方向为正北， angle = 0。收到右转命令，则 angle = 1,有规律 `angle = (angle + 1) % 4`；收到左转命令， 则 angle = 3， 有规律 `angle = (angle - 1 + 4) % 4`， 这里 +4 是为了避免出现负数的情况。

第二个难点是，前方有障碍物如何前进的问题。这里是通过每前进一步，都判断这个位置是否有障碍物，若没有障碍物，则更新欧氏距离。这里为了方便判断障碍物存在与否，把障碍物的 xy 坐标写到一个 32位的数中，存入 hashset，通过 contains 来判断存在与否。

``` java
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // 北、东、南、西对应的 x 和 y 轴的位移
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
                    } else {
                        break;
                    }
                }
            }
        }
        return max;
    }
}
```

[title]: https://leetcode.com/problems/walking-robot-simulation
