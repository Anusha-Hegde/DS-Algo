package leetOctober.LeetNovember.Week2;

import java.util.*;

/**
 * Given the root of a binary tree, find the maximum value V 
 * for which there exist different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
 * 
 * A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.
 */


/**
 * public class TreeNode { 
 *      int val; 
 *      TreeNode left; 
 *      TreeNode right; 
 *      TreeNode() {} 
 *      TreeNode(int val) { this.val = val; }
 *      TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */


class Solution {

    int res = 0;
    
    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return res;
    }
    
    int[] dfs(TreeNode node){
        
        if(node == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        
        if(node.left == null && node.right == null) return new int[]{node.val, node.val};
        
        int[] right = dfs(node.right);
        int[] left = dfs(node.left);
        
        int min = Math.min(left[0], right[0]);
        int max = Math.max(left[1], right[1]);
        
        res = Math.max(res, Math.max(Math.abs(node.val - min), Math.abs(node.val - max)));
        
        return new int[]{Math.min(min, node.val), Math.max(max, node.val)};
        
    }
}