# [Min Stack][title]

## Description

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

```
* push(x) -- Push element x onto stack.
* pop() -- Removes the element on top of the stack.
* top() -- Get the top element.
* getMin() -- Retrieve the minimum element in the stack.
```

**Example:**  

```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
```

**Tags:** Stack, Design

**Difficulty:** Easy

## 思路

栈的设计。用两个栈来实现，一个是主栈，所有的 pop 和 push 都从里面操作。备用栈，用来在最小值被弹出时，找出新的最小值。最小值被弹出后，把主栈中所有数据弹出，压到备用栈中，找出最小值，而后再恢复到主栈中。

``` java
class MinStack {
    Stack<Integer> st1,st2;
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
        min = Math.min(min, x);
    }
    
    public void pop() {
        if(min == st1.pop()) {
            min = Integer.MAX_VALUE;
            while(!st1.isEmpty()) {
                int cur = st1.pop();
                min = Math.min(cur, min);
                st2.push(cur);
            }
            while(!st2.isEmpty()) {
                st1.push(st2.pop());
            }
        }
       
    }
    
    public int top() {
        return st1.peek().intValue();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

[title]: https://leetcode.com/problems/min-stack
