# [Employee Importance][title]

## Description

You are given a data structure of employee information, which includes the
employee's **unique id** , his **importance value** and his **direct**
subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the
leader of employee 3. They have importance value 15, 10 and 5, respectively.
Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2,
10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also
a subordinate of employee 1, the relationship is **not direct**.

Now given the employee information of a company, and an employee id, you need
to return the total importance value of this employee and all his
subordinates.

**Example 1:**  
        

**Note:**  

  1. One employee has at most one **direct** leader and may have several subordinates.
  2. The maximum number of employees won't exceed 2000.


**Tags:** Hash Table, Depth-first Search, Breadth-first Search

**Difficulty:** Easy

## 思路

``` java
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    int sum = 0;
    public int getImportance(List<Employee> employees, int id) {
        helper(employees, id);
        return sum;
    }
    public void helper(List<Employee> employees, int id) {
        for(Employee employee: employees) {
            if(employee.id == id) {
                sum += employee.importance;
                for(int subordinate: employee.subordinates) {
                    helper(employees, subordinate);
                }
                break;
            }
        } 
    }
}
```

[title]: https://leetcode.com/problems/employee-importance