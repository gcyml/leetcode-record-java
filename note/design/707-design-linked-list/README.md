# [Design Linked List][title]

## Description

Design your implementation of the linked list. You can choose to use the
singly linked list or the doubly linked list. A node in a singly linked list
should have two attributes: `val` and `next`. `val` is the value of the
current node, and `next` is a pointer/reference to the next node. If you want
to use the doubly linked list, you will need one more attribute `prev` to
indicate the previous node in the linked list. Assume all nodes in the linked
list are 0-indexed.

Implement these functions in your linked list class:

  * get(index) : Get the value of the `index`-th node in the linked list. If the index is invalid, return `-1`.
  * addAtHead(val) : Add a node of value `val` before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
  * addAtTail(val) : Append a node of value `val` to the last element of the linked list.
  * addAtIndex(index, val) : Add a node of value `val` before the `index`-th node in the linked list. If `index` equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
  * deleteAtIndex(index) : Delete the `index`-th node in the linked list, if the index is valid.

**Example:**
            MyLinkedList linkedList = new MyLinkedList();    linkedList.addAtHead(1);    linkedList.addAtTail(3);    linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3    linkedList.get(1);            // returns 2    linkedList.deleteAtIndex(1);  // now the linked list is 1->3    linkedList.get(1);            // returns 3    

**Note:**

  * All values will be in the range of `[1, 1000]`.
  * The number of operations will be in the range of `[1, 1000]`.
  * Please do not use the built-in LinkedList library.


**Tags:** Linked List, Design

**Difficulty:** Easy

## 思路

``` java
class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode() {
            next = null;
        }
    }
    ListNode head = null;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode();
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index > size-1) {
            return -1;
        }
        ListNode tmp = head;
        while(index-- > 0) {
            tmp = tmp.next;
        }
        return tmp.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(size == 0) {
            head.val = val;
        } else {
            ListNode tmp = new ListNode(val);
            tmp.next = head;
            head = tmp;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(size == 0) {
            head.val = val;
        } else {
            ListNode tmp = head;
            while(tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new ListNode(val);            
        }    
 
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index >= 0 && index <= size) {
            if(index == 0) {
                addAtHead(val);
            }else if(index < size) {
                ListNode pre = head;
                while(index-- > 1) {
                    pre = pre.next;
                }
                ListNode next = pre.next;
                pre.next = new ListNode(val);
                pre.next.next = next;
                size++;
            } else if(index == size) {
                addAtTail(val);
            }
            
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= 0 && index < size) {
            ListNode pre = head;
            if(index == 0) {
                if(size == 1) {
                    head = new ListNode();
                    size = 0;
                } else {
                    head = head.next;
                }
            } else {
                 while(index-- > 1) {
                    pre = pre.next;
                }
                pre.next = pre.next.next;
            }
            size--;
        }
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
```

[title]: https://leetcode.com/problems/design-linked-list
