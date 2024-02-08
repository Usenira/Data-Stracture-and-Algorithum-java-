package BinaryTree;

public class Univalued {
    public static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean isUnivalTree(Node root) {
        if(root == null) {
            return true;
        }
        if(root.left != null && root.data != root.left.data) {
            return false;
        }
        if(root.right != null && root.data != root.right.data) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.right.right = new Node(1);

        if(isUnivalTree(root)) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}
