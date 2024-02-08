package code.Nira.BinaryTress;

import java.lang.annotation.Retention;

public class countofNodes {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
        }
        public static int countNodes(Node root ) {
            if(root == null) {
                return 0;
            }
            int lc = countNodes(root.left);
            int rc = countNodes(root.right);
            return lc+rc+1;
        }

        public static int sumofNodes(Node root) {
            if(root == null) {
                return 0;
            }
            int leftsm = sumofNodes(root.left);
            int rightsm = sumofNodes(root.right);
            return leftsm+rightsm+root.data;
         
        }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(sumofNodes(root));
    }
}
