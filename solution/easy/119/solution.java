class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastRow = new ArrayList<>();
        for(int i = 1;i<=rowIndex+1;i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j =1;j<i;j++) {
                if(j == i-1) {
                    row.add(1);
                }else {
                    row.add(lastRow.get(j) + lastRow.get(j-1));
                }    
            }
            if(i == rowIndex+1) {
                return row;
            }
            lastRow = row;
        }
        return null;
    }
}