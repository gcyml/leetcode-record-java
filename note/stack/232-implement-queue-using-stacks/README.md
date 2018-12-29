# [Implement Queue using Stacks][title]

## Description

Implement the following operations of a queue using stacks.

  * push(x) -- Push element x to the back of queue.
  * pop() -- Removes the element from in front of queue.
  * peek() -- Get the front element.
  * empty() -- Return whether the queue is empty.

**Example:**
            MyQueue queue = new MyQueue();        queue.push(1);    queue.push(2);      queue.peek();  // returns 1    queue.pop();   // returns 1    queue.empty(); // returns false

**Notes:**

  * You must use _only_ standard operations of a stack -- which means only `push to top`, `peek/pop from top`, `size`, and `is empty` operations are valid.
  * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
  * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).


**Tags:** Stack, Design

**Difficulty:** Easy

## 思路

``` java
class MyQueue {
    Stack<Integer> st1,st2;
    /** Initialize your data structure here. */
    public MyQueue() {
        st1=new Stack<Integer>();
        st2=new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(st2.isEmpty()) {
            st2.push(x);
        } else {
               while(!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        st1.push(x);
        while(!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        }
      
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return st2.pop().intValue();
    }
    
    /** Get the front element. */
    public int peek() {
        return st2.peek().intValue();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```

[title]: https://leetcode.com/problems/implement-queue-using-stacks
