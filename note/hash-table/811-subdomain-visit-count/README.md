# [Subdomain Visit Count][title]

## Description

A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".

We are given a list `cpdomains` of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.

**Example 1:**

```
Input:
[ "9001 discuss.leetcode.com"]
Output:
[ "9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
Explanation:
We only have one website domain:  "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
```

**Example 2:**

```
Input:
[ "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
Output:
[ "901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
Explanation:
We will visit  "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
```

**Notes:**

* The length of `cpdomains` will not exceed `100`.
* The length of each domain name will not exceed `100`.
* Each address will have either 1 or 2 "." characters.
* The input count in any count-paired domain will not exceed `10000`.
* The answer output can be returned in any order.

**Tags:** Hash Table

**Difficulty:** Easy

## 思路

题目过长，变成阅读理解了。解法也很简单，只要把访问次数和链接用 split 分割，然后再把不断拆分成多个 domain，这里用到的逻辑是只要还存在 `.`，就不断拆分domain，把对应的访问次数存入映射表中累加。最后把映射表转成列表即可。

``` java
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String cpdomain : cpdomains){
            String[] array = cpdomain.split(" ");
            int count = Integer.parseInt(array[0]);
            String domain = array[1];
            if(map.containsKey(domain)) {
                map.put(domain, map.get(domain)+count);
            }else {
                map.put(domain, count);
            }
            while(domain.indexOf('.') != -1) {
                domain = domain.substring(domain.indexOf('.')+1);
                if(map.containsKey(domain)) {
                    map.put(domain, map.get(domain)+count);
                }else {
                    map.put(domain, count);
                }
            }
        }
        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getValue() + " " + entry.getKey());
        }
        return list;
    }
}
```

[title]: https://leetcode.com/problems/subdomain-visit-count
