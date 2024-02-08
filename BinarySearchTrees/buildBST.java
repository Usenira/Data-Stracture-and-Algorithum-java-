package BinarySearchTrees;

public class buildBST {
    
    static class Node {
               int data;
               Node left, right;
               Node(int data) {
                   this.data = data;
            }
    }

    public static Node insert(Node root, int val){
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(root.data > val) {
            root.left = insert(root.left, val);
        } else {
          root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
     }
     
     public static void main(String[] args) {
    int val[] = {1,3,12,45,32,87,4,34};
    Node root = null;
    for (int i = 0; i < val.length; i++) {
        root = insert(root, val[i]);
    }
    inOrder(root);
    System.out.println();
    }
}
