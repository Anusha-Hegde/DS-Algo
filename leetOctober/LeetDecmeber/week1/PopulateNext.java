package leetOctober.LeetDecmeber.week1;


/**
 * Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
 */


class PopulateNext {
    public Node connect(Node root) {
        dfs(root);
        return root;
    }
    public void dfs(Node node){
        if(node == null) return;
        Node temp1 = node;
        Node temp2 = null;
        while(temp1 != null){
            if(temp1.left != null){
                if(temp2 != null) temp2.next = temp1.left;
                temp2 = temp1.left;
            }
            if(temp1.right != null){
                if(temp2 != null) temp2.next = temp1.right;
                temp2 = temp1.right;
            }
            if(node.right == null && node.left == null) node = temp1;
            temp1 = temp1.next;
        }
        
        dfs(node.right);
        dfs(node.left);
        
    }
}