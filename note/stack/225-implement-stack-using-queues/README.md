# [Implement Stack using Queues][title]

## Description

Implement the following operations of a stack using queues.

* push(x) -- Push element x onto stack.
* pop() -- Removes the element on top of the stack.
* top() -- Get the top element.
* empty() -- Return whether the stack is empty.

**Example:**

```
MyStack stack = new MyStack();

stack.push(1);
stack.push(2);  
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
```

**Notes:**

* You must use _only_ standard operations of a queue -- which means only `push to back`, `peek/pop from front`, `size`, and `is empty` operations are valid.
* Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
* You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

**Tags:** Stack, Design

**Difficulty:** Easy

## 思路

用队列实现栈。

栈和队列的最大区别在于一个是“先进后出”，另一个是“先进先出”。用两个队列来实现“先进后出”。当做 pop 操作时，把存储数据的队列中的数据入到从队列中，当主队列只剩一个时，此时即为栈中栈顶的对象。

``` java
class MyStack {
    Queue<Integer> queue1,queue2;
    Integer top;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
        top = x;    
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int res = -1;
        while(!queue1.isEmpty()) {
            res = queue1.poll();
            if(!queue1.isEmpty()) {
                queue2.offer(res);
            }
        }
        while(!queue2.isEmpty()) {
            push(queue2.poll());
        }
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
```

[title]: https://leetcode.com/problems/implement-stack-using-queues
