package leetOctober.LeetDecmeber;

/**
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class MaxDepth {
    int max = 0;
    
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }
}
