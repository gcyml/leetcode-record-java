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

``` java
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int maxDistance = 100*100; // ä¸¤ä¸ªèç¹ä¹é´çæè¿è·ç¦»
        int[][] graph = new int[N][N];
        
        // åå§åææèç¹ä¹é´çè·ç¦»ä¸ºæè¿è·ç¦»
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = i==j? 0 : maxDistance;
            }
        }
        // å¤çå¾ä¿¡æ¯ï¼å°å¯ä»¥å°è¾¾çç¹ä¹é´çè·¯å¾è·ç¦»å­å¥è¡¨ä¸­
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
