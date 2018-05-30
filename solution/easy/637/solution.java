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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<Double>();
        int curIndex = 1;
        int nextIndex = 0;
        double nodeSum = 1;
        double sum = 0;
        queue.offer(root);
        while(!queue.isEmpty()) {
            root = queue.poll();
            sum += root.val;
            curIndex--;
            if(root.left != null) {
                queue.offer(root.left);
                nextIndex++;
            }
            if(root.right != null) {
                queue.offer(root.right);
                nextIndex++;
            }
            if(curIndex == 0) {
                curIndex = nextIndex;

                result.add(sum/nodeSum);
                nodeSum = nextIndex;
                nextIndex = 0;
                sum = 0;
                
            }

            
        }
        return result;
    }
}