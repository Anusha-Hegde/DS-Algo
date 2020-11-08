package leetOctober.LeetNovember.Week2;

/** 
 * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode() {}
    *     TreeNode(int val) { this.val = val; }
    *     TreeNode(int val, TreeNode left, TreeNode right) {
    *         this.val = val;
    *         this.left = left;
    *         this.right = right;
    *     }
    * }
    */

public class BinTreeTilt {
    int sum;
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        sum = 0;
        dfs(root);
        return sum;
    }
    public int dfs(TreeNode node){
        int right = 0, left = 0;
        if(node.right != null) right = dfs(node.right);
        if(node.left != null) left = dfs(node.left);
        sum += Math.abs(right - left);
        return right + left + node.val; 
    }
}
