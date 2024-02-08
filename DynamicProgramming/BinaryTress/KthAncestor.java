package code.Nira.BinaryTress;

public class KthAncestor {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data; 
        }
    }
    public static int KAncestor(Node root, int n, int k) {
        if(root == null) {
            return -1;
        }

        if(root.data == n){
            return 0;
        }
       int leftDist = KAncestor(root.left, n, k);
       int rightDist = KAncestor(root.right, n, k);
       if(leftDist == -1 && rightDist == -1) {
        return -1;
       }
       int max = Math.max(leftDist, rightDist);
       if(max+1 == k) {
        System.out.println(root.data);
       }
       return max+1;
    }

    public static int Transform(Node root) {
        if(root == null) {
            return 0;
        }
        int leftChild = Transform(root.left);
        int rightChild = Transform(root.right);

        int data = root.data;

        int newleft = root.left == null ? 0 : root.left.data ;
        int newright = root.right == null ? 0 : root.right.data;
        

        root.data = newleft + leftChild + newright + rightChild;
        return data;
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // int n = 4, k= 7;
        System.out.println(KAncestor(root, 4, 2));
        
    }
}
