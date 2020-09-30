package max_av_subtree;

import java.util.*;

public class Node {

    public int data;
    List<Node> children;

    public Node(int data) {
        this.data = data;
        children = new ArrayList<Node>();
    }

}
