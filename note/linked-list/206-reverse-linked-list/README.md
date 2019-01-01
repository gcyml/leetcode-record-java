# [Reverse Linked List][title]

## Description

Reverse a singly linked list.

**Example:**

```
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
```

**Follow up:**

A linked list can be reversed either iteratively or recursively. Could you implement both?

**Tags:** Linked List

**Difficulty:** Easy

## 思路

翻转单向链表。

用递归的方式来实现，深度遍历把当前节点的后面所有节点翻转后，再把这个节点和下一节点进行翻转。设当前节点为 a，要实现翻转，先把 a.next.next = a，此时 a 的 next 指向仍然为 a.next，这就构成了死环，把 a.next 指向 null。此时，即完成了链表的翻转，最后由于得到的结果是链表的尾部，因此只有在最后一个节点时，才做返回，且递归过程中，一直把最后一个节点向上递归返回，最后得到的结果即为旧链表的 tail，即新链表的 head。

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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next==null) {
            return head;
        }
        ListNode tmp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tmp;
    }
}
```

[title]: https://leetcode.com/problems/reverse-linked-list
