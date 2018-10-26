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