# [Middle of the Linked List][title]

## Description

Given a non-empty, singly linked list with head node `head`, return a middle node of linked list.

If there are two middle nodes, return the second middle node.

**Example 1:**

```
Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
```

**Example 2:**

```
Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
```

**Note:**

* The number of nodes in the given list will be between `1` and `100`.

**Tags:** Linked List

**Difficulty:** Easy

## 思路

找到单向链表的中间节点。用双指针的方式，慢指针走一步，快指针走两步，快指针走完时，慢指针指向的节点即为中间节点。

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
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
```

[title]: https://leetcode.com/problems/middle-of-the-linked-list
