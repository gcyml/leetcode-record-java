# [Delete Node in a Linked List][title]

## Description

Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Given linked list -- head = [4,5,1,9], which looks like following:

```
    4 -> 5 -> 1 -> 9
```

**Example 1:**

```
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
```

**Example 2:**

```
Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
```

**Note:**

* The linked list will have at least two elements.
* All of the nodes' values will be unique.
* The given node will not be the tail and it will always be a valid node of the linked list.
* Do not return anything from your function.

**Tags:** Linked List

**Difficulty:** Easy

## 思路

删除单向链表。由于只给出了需要删去的节点，因此不能用传统的打断重连的方式来删除节点。因此，只能通过把当前节点的私有变量变成下一个节点的私有变量，以桃代李，把当前节点变成 next。

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
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
```

[title]: https://leetcode.com/problems/delete-node-in-a-linked-list
