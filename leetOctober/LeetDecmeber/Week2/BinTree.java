package leetOctober.LeetDecmeber.Week2;

import leetOctober.LeetDecmeber.TreeNode;

/**
 * Given the root of a binary tree, the depth of each node is the shortest
 * distance to the root.
 * 
 * Return the smallest subtree such that it contains all the deepest nodes in
 * the original tree.
 * 
 * A node is called the deepest if it has the largest depth possible among any
 * node in the entire tree.
 * 
 * The subtree of a node is tree consisting of that node, plus the set of all
 * descendants of that node.
 */

public class BinTree {

    int max_depth = 0;
    TreeNode res = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs1(root, 0);
        dfs2(root, 0);
        return res;
    }

    public void dfs1(TreeNode node, int depth) {
        max_depth = Math.max(depth, max_depth);
        if (node.right != null)
            dfs1(node.right, depth + 1);
        if (node.left != null)
            dfs1(node.left, depth + 1);
    }

    public boolean dfs2(TreeNode node, int depth) {

        if (node == null)
            return false;

        if (depth == max_depth) {
            res = node;
            return true;
        }

        boolean right = false;
        boolean left = false;
        right = dfs2(node.right, depth + 1);
        left = dfs2(node.left, depth + 1);

        if (right && left)
            res = node;

        return (right || left);
    }
}

/**
 * 
 * class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
       if (root == null) {
           return null;
       }
        
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        
        if (leftDepth == rightDepth) {
            return root;
        } else if (leftDepth > rightDepth) {
            return lcaDeepestLeaves(root.left);
        }
        
        return lcaDeepestLeaves(root.right);
    }
    
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
 */