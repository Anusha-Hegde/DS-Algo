package leetOctober.LeetDecmeber.week1;

/**
 * Given the root of a binary search tree, rearrange the tree in in-order so that 
 * the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.
 */

public class IncOrderSear {
    
    TreeNode temp = new TreeNode();
    TreeNode res = temp;
    TreeNode temp2;
    
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return res.right;
    }
    
    public void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        temp.right = new TreeNode(node.val);
        temp = temp.right;
        inorder(node.right);
    }
}
