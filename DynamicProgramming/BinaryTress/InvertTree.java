package code.Nira.BinaryTress;

public class InvertTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
  public static Node Mirror(Node node) {
    if(node == null) {
        return node;
    }
    Node left = Mirror(node.left);
    Node right = Mirror(node.right);

    node.left = right;
    node.right = left;
    return node;
  }
   
   public static void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data + " ");
        inOrder(node.right);
    }
}
    public static void main(String[] args) {
       Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
    }
}
