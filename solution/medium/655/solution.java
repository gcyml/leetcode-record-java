/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getTreeHigh(root);  
        int size=(int)Math.pow(2, height)-1;  
        
        List<List<String>> res = new ArrayList<List<String>>(); 
        for(int i=0;i<height;i++){  
            String[] strs = new String[size];
            Arrays.fill(strs, "");
            List<String> list = Arrays.asList(strs);
            res.add(list);  
        }
        printTreeHelper(res, root, 0, 0, size-1);
        return res;
    }  
        
    public void printTreeHelper(List<List<String>> res, TreeNode root, int high, int left, int right) {
        if(root == null) {
            return;
        }
        int colIndex = (left+right)/2;
        res.get(high).set(colIndex, root.val + "");
        printTreeHelper(res, root.left, high+1, left, colIndex-1);
        printTreeHelper(res, root.right, high+1, colIndex+1, right);
        
    }
    public int getTreeHigh(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(getTreeHigh(root.left), getTreeHigh(root.right)) +1;
    }
}