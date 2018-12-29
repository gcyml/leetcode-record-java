# [Middle of the Linked List][title]

## Description

Given a non-empty, singly linked list with head node `head`, return a middle
node of linked list.

If there are two middle nodes, return the second middle node.



**Example 1:**
        

**Example 2:**
        



**Note:**

  * The number of nodes in the given list will be between `1` and `100`.


**Tags:** Linked List

**Difficulty:** Easy

## 思路

``` java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast =head, slow =head;
        while(fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
```

[title]: https://leetcode.com/problems/middle-of-the-linked-list