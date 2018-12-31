# [Linked List Cycle][title]

## Description

Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer `pos` which represents the position (0-indexed) in the linked list where tail connects to. If `pos` is `-1`, then there is no cycle in the linked list.

**Example 1:**

```
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.
```

![pic](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png)

**Example 2:**

```
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.
```

![pic](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png)

**Example 3:**

```
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
```

![pic](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png)

**Follow up:**

Can you solve it using _O(1)_ (i.e. constant) memory?

**Tags:** Linked List, Two Pointers

**Difficulty:** Easy

## 思路

题意是判断链表中是否存在环。用双指针法解决。只需要设两个指针，一个每次走一步的慢指针和一个每次走两步的快指针，如果链表里有环的话，两个指针最终肯定会相遇。

这个解法真的太巧妙了，我是想不出来的。。。

``` java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while(fast != null) {  
            fast = fast.next;
            slow = slow.next;
            if(fast != null) {
                fast = fast.next;
                if(fast == slow) {
                    return true;
                }
            }
        }
        return false;
    }
}
```

[title]: https://leetcode.com/problems/linked-list-cycle
