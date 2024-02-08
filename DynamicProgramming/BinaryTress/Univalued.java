package code.Nira.BinaryTress;

public class Univalued {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }

    }
    // static Node newNode(int data) {
    //     Node temp = new Node();
    //     temp.data = data;
    //     temp.left = temp.right = null;
    //     return(temp);
    // }
    public static boolean BinaryTree(Node root) {
        if(root == null) {
            return true;
        }
        if(root.left != null && root.data != root.left.data) {
            return false;
        }
        if(root.right != null && root.data != root.right.data) {
            return false;
        }
        return BinaryTree(root.left) && BinaryTree(root.right);
    }

   
    public static void main(String[] args) {
    Node root = new Node(2);
    root.left = new Node(2);
    root.right = new Node(2);
    root.left.left = new Node(2);
    root.left.right = new Node(2);
    System.out.println(BinaryTree(root));
    }
}
