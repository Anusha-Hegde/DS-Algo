package leetOctober.LeetNovember.Week3;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */


/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
 */

 
class Solution {

    int sum = 0;
    int low, high;

    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        dfs(root);
        return sum;
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;
        if (node.val >= low && node.val <= high) {
            sum += node.val;
            dfs(node.right);
            dfs(node.left);
        } else if (node.val < low)
            dfs(node.right);
        else
            dfs(node.left);
    }
}