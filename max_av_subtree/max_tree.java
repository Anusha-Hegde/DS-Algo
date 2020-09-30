package max_av_subtree;

import java.util.ArrayDeque;
import java.util.Queue;

// package max_av_subtree;

public class max_tree {

    double max_av = 0;
    int max_res = 0;

    public int findSubtree(Node root) {
        if (root == null)
            return 0;
        dfs(root);
        return max_res;
    }

    public void dfs(Node node) {

        Queue<Node> q = new ArrayDeque<Node>();
        int count = 1;
        int num = 0;

        q.add(node);

        while (!q.isEmpty()) {

            Node temp = q.poll();
            num += temp.data;

            if (temp.children.size() > 0) {
                for (Node i : temp.children) {
                    q.add(i);
                    count++;
                    if (i.children.size() > 0) {
                        dfs(i);
                    }
                }
            }

        }
        double c_av = num / count;
        System.out.println("average at node : " + node.data + "\n" + num + "/" + count + " = " + c_av + "\n");
        if(max_av < c_av){
            max_av = c_av;
            max_res = node.data;
        }

    }
}
