package max_av_subtree;

public class Main {
    public static void main(String... s) {
        Node one = new Node(11);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(15);
        Node five = new Node(8);
        Node six = new Node(12);
        Node seven = new Node(18);
        Node eight = new Node(100);
        six.children.add(one);
        six.children.add(two);
        six.children.add(three);
        seven.children.add(four);
        seven.children.add(five);
        eight.children.add(six);
        eight.children.add(seven);
        max_tree test = new max_tree();
        System.out.println("max average is at node : " + test.findSubtree(eight));
    }
}
