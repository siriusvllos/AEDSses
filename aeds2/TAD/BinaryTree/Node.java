package BinaryTree;

public class Node {

    public int value; // Content
    public Node left, right; // Left & right children

    public Node(int val) {
        this(val, null, null);
    }

    public Node(int val, Node l, Node r) {
        this.value = val;
        this.left = l;
        this.right = r;
    }
}
