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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) 
            return result;
        List<List<Integer>> levelListRes = new ArrayList<List<Integer>>();
        ArrayList<Integer> levelres = new ArrayList<Integer>(); 
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);//将s作为起始顶点加入队列
        int curIndex = 1;
        int nextIndex = 0;
        while(!q.isEmpty())
        {
            curIndex--;
            TreeNode top = q.poll(); //取出队首元素
            levelres.add(top.val);
            if(top.left != null) {
                nextIndex++;
                q.add(top.left);
            }
            if(top.right != null) {
                q.add(top.right);
                nextIndex++;
            }
            if(curIndex == 0) {
                curIndex = nextIndex;
                nextIndex = 0;
                levelListRes.add(levelres);
                levelres = new ArrayList<Integer>();
                
            }   
        }
        for(int i = levelListRes.size()-1;i>=0;i--) {
            result.add(levelListRes.get(i));
        }
        
        return result;
    }
}