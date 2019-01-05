# [Network Delay Time][title]

## Description

There are `N` network nodes, labelled `1` to `N`.

Given `times`, a list of travel times as **directed** edges `times[i] = (u, v,
w)`, where `u` is the source node, `v` is the target node, and `w` is the time
it takes for a signal to travel from source to target.

Now, we send a signal from a certain node `K`. How long will it take for all
nodes to receive the signal? If it is impossible, return `-1`.

**Note:**  

  1. `N` will be in the range `[1, 100]`.
  2. `K` will be in the range `[1, N]`.
  3. The length of `times` will be in the range `[1, 6000]`.
  4. All edges `times[i] = (u, v, w)` will have `1 <= u, v <= N` and `1 <= w <= 100`.

**Tags:** Heap, Depth-first Search, Breadth-first Search, Graph

**Difficulty:** Easy

## 思路

由于网络节点属于多源路径，所以用 [弗洛伊德算法算法][floyd] 找出节点到节点之间的最短路径，然后找出由 K 点到所有节点的最大值即为所要结果。

``` java
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        // 两个节点之间的最远距离
        int maxDistance = 100*100;
        int[][] graph = new int[N][N];

        // 初始化所有节点之间的距离为最远距离
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = i==j? 0 : maxDistance;
            }
        }
        // 处理图信息，将可以到达的点之间的路径距离存入表中
        for(int i=0;i<times.length;i++) {
            graph[times[i][0]-1][times[i][1] -1] = times[i][2];
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        int res = -1;
        for (int i = 0; i < N; i++) {
            if(graph[K-1][i] == maxDistance) {
                return -1;
            }
            res = Math.max(graph[K-1][i], res);
        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/network-delay-time
[floyd]: https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
