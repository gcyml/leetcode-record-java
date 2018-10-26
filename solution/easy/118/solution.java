class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i =1;i<=numRows;i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j =1;j<i;j++) {
                if(j == i-1) {
                    row.add(1);
                }else {
                    // System.out.println(i + "," + j);
                    row.add(res.get(i-1-1).get(j) + res.get(i-1-1).get(j-1));
                }    
            }
            res.add(row);
        }
        return res;
    }
}