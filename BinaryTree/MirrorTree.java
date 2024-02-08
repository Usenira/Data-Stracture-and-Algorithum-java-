package BinaryTree;

public class MirrorTree {
    public static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    public static Node mirror(Node root) {
        if(root == null) {
            return root;
        }

        //do the subs
        Node left = mirror(root.left);
        Node right = mirror(root.right);
         
        //swap the left and right pointer
        root.left = right;
        root.right = left;
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
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        System.out.println("Inorder traversal of input  is:");
        inOrder(root);
        System.out.println("");
        mirror(root);

        System.out.println("Inorder traversal of binary  is:");
        inOrder(root);
    }
}
