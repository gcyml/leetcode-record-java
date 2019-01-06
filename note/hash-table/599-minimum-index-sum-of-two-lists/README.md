# [Minimum Index Sum of Two Lists][title]

## Description

Suppose Andy and Doris want to choose a restaurant for dinner, and they both
have a list of favorite restaurants represented by strings.

You need to help them find out their **common interest** with the **least list
index sum**. If there is a choice tie between answers, output all of them with
no order requirement. You could assume there always exists an answer.

**Example 1:**  

```
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
```

**Example 2:**  

```
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
```

**Note:**  

1. The length of both lists will be in the range of [1, 1000].
2. The length of strings in both lists will be in the range of [1, 30].
3. The index is starting from 0 to the list length minus 1.
4. No duplicates in both lists.

**Tags:** Hash Table

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                int indexSum =  map.get(list2[i]) + i;
                if(indexSum < min) {
                    list.clear();
                    list.add(list2[i]);
                    min = indexSum;
                } else if(indexSum == min){
                    list.add(list2[i]);
                }
            }
        }
        String[] res = new String[list.size()];
        list.toArray(res);
        return res;
    }
}
```

[title]: https://leetcode.com/problems/minimum-index-sum-of-two-lists
