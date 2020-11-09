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
    
    int res;
    public int maxAncestorDiff(TreeNode root) {
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }
    public List<Integer> dfs(TreeNode node){
        List<Integer> temp_res = new ArrayList<>();
        List<Integer> temp;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        int t_res;
        if(node.right != null){
            temp = dfs(node.right);
            t_res = Math.max(Math.abs(node.val - temp.get(0)), Math.abs(node.val - temp.get(1)));
            res = Math.max(res, t_res);
            mini = Math.min(mini, temp.get(0));
            maxi = Math.max(maxi, temp.get(1));
        }
        if(node.left != null){
            temp = dfs(node.left);
            t_res = Math.max(Math.abs(node.val - temp.get(0)), Math.abs(node.val - temp.get(1)));
            res = Math.max(res, t_res);
            mini = Math.min(mini, temp.get(0));
            maxi = Math.max(maxi, temp.get(1));
        }
        temp_res.add(Math.min(mini, node.val));
        temp_res.add(Math.max(maxi, node.val));
        return temp_res;
        
    }
}