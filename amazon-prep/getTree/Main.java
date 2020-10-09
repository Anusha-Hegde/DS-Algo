package getTree;

public class Main {
    String s;
    int num = 0, count = 0;

    public TreeNode recoverFromPreorder(String S) {

        s = S;

        TreeNode root = new TreeNode();

        root = dfs(root, 0);

        return root;
    }

    public TreeNode dfs(TreeNode node, int level) {

        if (s.length() == 0)
            return node;

        count = 0;
        while (s.charAt(count) == '-') count++;
        
        num = count;
        while (num < s.length() && Character.isDigit(s.charAt(num))) num++;

        if (count == level) {
            node = new TreeNode(Integer.parseInt(s.substring(count, num)));
            s = s.substring(num);
            node.left = dfs(node.left, level + 1);
            node.right = dfs(node.right, level + 1);
        }

        return node;
    }
}
