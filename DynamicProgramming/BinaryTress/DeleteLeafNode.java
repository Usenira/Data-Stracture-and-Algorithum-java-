package code.Nira.BinaryTress;

public class DeleteLeafNode {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    public static Node leafNode(Node root, int x) {
        if(root == null) {
            return null;
        }
        root.left = leafNode(root.left, x);
        root.right = leafNode(root.right, x);

        if(root.data == x && root.left == null && root.right == null) {
            return null;
        } return root;
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return ;
        }
        inOrder(root.left);
        System.out.println(root.data+" ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);

        leafNode(root, 3);
        System.out.println("Inorder traversal after deletion ");
        inOrder(root);
    }
}
