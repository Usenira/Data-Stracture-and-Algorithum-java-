package BinaryTree;

public class DeleteLeaf {
    
    public static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    public static Node LeafNode(Node root, int x) {
        if(root == null) {
            return null;
        }

        root.left = LeafNode(root.left,x);
        root.right = LeafNode(root.right,x);

        if(root.data == x && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    //inOrder method
    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);

        LeafNode(root, 3);
        inOrder(root);
    }
}
