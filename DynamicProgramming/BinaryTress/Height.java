package code.Nira.BinaryTress;

public class Height {
    static class Node {
        int data;
        Node left;
        Node right;

         Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int heights(Node root) {
        if(root == null) {
            return 0;
        }
        int lh = heights(root.left);
        int rh = heights(root.right);
        return Math.max(lh, rh)+1;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(7);

        root.left.right = new Node(5);
        root.left.right = new Node(6);
        System.out.println(heights(root));
    }
}
