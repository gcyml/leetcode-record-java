# [Linked List Cycle][title]

## Description

Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer `pos` which
represents the position (0-indexed) in the linked list where tail connects to.
If `pos` is `-1`, then there is no cycle in the linked list.



**Example 1:**
        

![](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png)

**Example 2:**
        

![](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png)

**Example 3:**
        

![](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png)



**Follow up:**

Can you solve it using _O(1)_ (i.e. constant) memory?


**Tags:** Linked List, Two Pointers

**Difficulty:** Easy

## 思路

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