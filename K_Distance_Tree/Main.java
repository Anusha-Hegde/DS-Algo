package K_Distance_Tree;

import java.util.*;

public class Main {

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    int count;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        find1(root, target);

        find2(root, target, K, map.get(root.val));

        return res;
    }

    public int find1(TreeNode node, TreeNode target) {

        if (node == null)
            return -1;

        if (node == target) {
            map.put(node.val, 0);
            return 0;
        }

        count = find1(node.right, target);
        if (count >= 0) {
            map.put(node.val, count + 1);
            return count + 1;
        }
        count = find1(node.left, target);
        if (count >= 0) {
            map.put(node.val, count + 1);
            return count + 1;
        }

        return -1;

    }

    public void find2(TreeNode node, TreeNode target, int K, int dist) {
        if (node == null)
            return;

        if (map.containsKey(node.val))
            dist = map.get(node.val);
        if (dist == K)
            res.add(node.val);

        find2(node.right, target, K, dist + 1);
        find2(node.left, target, K, dist + 1);

    }
}