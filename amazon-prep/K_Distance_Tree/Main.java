package K_Distance_Tree;

import java.util.*;

public class Main {

    List<Integer> res = new ArrayList<>();
    int count;
    int K;
    TreeNode target;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        this.target = target;
        this.K = K;

        find1(root);

        return res;
    }

    public int find1(TreeNode node) {

        if (node == null)
            return 0;

        if (node == target) {
            find2(node, 0);
            return 1;
        }

        count = find1(node.right);
        if (count > 0) {
            if (count == K)
                res.add(node.val);
            if (count < K)
                find2(node.left, count + 1);
            return count + 1;
        }

        count = find1(node.left);
        if (count > 0) {
            if (count < K)
                find2(node.right, count + 1);
            if (count == K)
                res.add(node.val);
            return count + 1;
        }

        return 0;

    }

    public void find2(TreeNode node, int length) {

        if (node == null || length > K)
            return;

        if (length == K)
            res.add(node.val);

        find2(node.right, length + 1);
        find2(node.left, length + 1);
    }
}