# [Kth Largest Element in a Stream][title]

## Description

Design a class to find the **k** th largest element in a stream. Note that it
is the kth largest element in the sorted order, not the kth distinct element.

Your `KthLargest` class will have a constructor which accepts an integer `k`
and an integer array `nums`, which contains initial elements from the stream.
For each call to the method `KthLargest.add`, return the element representing
the kth largest element in the stream.

**Example:**
            int k = 3;    int[] arr = [4,5,8,2];    KthLargest kthLargest = new KthLargest(3, arr);    kthLargest.add(3);   // returns 4    kthLargest.add(5);   // returns 5    kthLargest.add(10);  // returns 5    kthLargest.add(9);   // returns 8    kthLargest.add(4);   // returns 8    

**Note:**  
You may assume that  `nums`' length ≥ `k-1` and `k` ≥ 1.


**Tags:** Heap

**Difficulty:** Easy

## 思路

``` java
class KthLargest {
    
    PriorityQueue<Integer> p;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        p = new PriorityQueue<Integer>();
        for(int i = 0 ; i < nums.length; i++){
            p.add(nums[i]);
            if(p.size()>k) p.poll();
        }
    }
    
    public int add(int val) {
        p.add(val);
        if(p.size()>k) p.poll();
        return p.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
```

[title]: https://leetcode.com/problems/kth-largest-element-in-a-stream
