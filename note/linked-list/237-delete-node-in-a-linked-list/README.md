# [Delete Node in a Linked List][title]

## Description

Write a function to delete a node (except the tail) in a singly linked list,
given only access to that node.

Given linked list -- head = [4,5,1,9], which looks like following:
        

**Example 1:**
        

**Example 2:**
        

**Note:**

  * The linked list will have at least two elements.
  * All of the nodes' values will be unique.
  * The given node will not be the tail and it will always be a valid node of the linked list.
  * Do not return anything from your function.


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
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
```

[title]: https://leetcode.com/problems/delete-node-in-a-linked-list