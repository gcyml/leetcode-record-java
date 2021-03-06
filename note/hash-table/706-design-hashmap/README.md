# [Design HashMap][title]

## Description

Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

* `put(key, value)` : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
* `get(key)`: Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
* `remove(key)` : Remove the mapping for the value key if this map contains the mapping for the key.

**Example:**

```
MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);
hashMap.put(2, 2);
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found)
```

**Note:**

* All keys and values will be in the range of `[0, 1000000]`.
* The number of operations will be in the range of `[1, 10000]`.
* Please do not use the built-in HashMap library.

**Tags:** Hash Table, Design

**Difficulty:** Easy

## 思路

设计一个映射表。这里用了列表 List 来实现的。

``` java
class MyHashMap {
    List<Integer> values;
    /** Initialize your data structure here. */
    public MyHashMap() {
        values = new ArrayList<>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(key >= values.size()) {
            for(int i=values.size();i<key;i++) {
                values.add(-1);
            }
            values.add(value);
        } else {
            values.set(key, value);

        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(key < values.size()) {
            return values.get(key);
        }
        return -1; 
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(key < values.size()) {
            values.set(key, -1);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
```

[title]: https://leetcode.com/problems/design-hashmap
