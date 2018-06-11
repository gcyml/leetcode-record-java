class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0;i < A.length; i++) {
            int size = A[i].length;
           for(int j = 0;j < size/2; j++) {
                int tmp = A[i][j] ^ 1;
                A[i][j] = A[i][size-1-j] ^ 1;
               A[i][size-1-j] = tmp;
            } 
            if(size%2 != 0) {
                A[i][size/2] ^= 1;
            }
        }
        return A;
    }
}