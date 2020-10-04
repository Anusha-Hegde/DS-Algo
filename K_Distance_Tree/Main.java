package K_Distance_Tree;

import java.util.*;

public class Main {

    List<Integer> res = new ArrayList<>();
    int count;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        find1(root, target, K);

        return res;
    }

    public int find1(TreeNode node, TreeNode target, int K) {

        if (node == null)
            return -1;

        if (node == target) {
            find2(node, target, K, 0);
            return 0;
        }

        count = find1(node.right, target, K);
        if (count >= 0) {
            if (count == K - 1)
                res.add(node.val);
            else
                find2(node.left, target, K, count + 2);
            return count + 1;
        }

        count = find1(node.left, target, K);
        if (count >= 0) {
            if (count == K - 1)
                res.add(node.val);
            else
                find2(node.right, target, K, count + 2);
            return count + 1;
        }

        return -1;

    }

    public void find2(TreeNode node, TreeNode target, int K, int length) {

        if (node == null || length > K)
            return;

        if (length == K)
            res.add(node.val);

        find2(node.right, target, K, length + 1);
        find2(node.left, target, K, length + 1);
    }
}