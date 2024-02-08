package BinarySearchTrees;

public class SearchBST {
    static class Node {
        int data;
        Node left,right;
        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean Search(Node root, int k) {
        if(root == null) {
            return false;
        }

        if(root.data == k) {
            return true;
        }
        if(k > root.data) {
           return Search(root.right, k);
        }
         else if(k < root.data) {
           return Search(root.left, k);
        }
        return false;
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(1);

        if(Search(root, 1)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
}
