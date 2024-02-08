package BinarySearchTrees;

public class LongestBST {
    static class Node {
        int data;
        Node left,right;
        public Node(int data) {
            this.data = data;
        }
    }

    static class Info{
        boolean isBST;
        int size;
        int max;
        int min;

        public Info(boolean isBST, int size, int max, int min){
            this.isBST = isBST;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    public static int maxBST = 0;
    public static Info Largestbst(Node root) {
        if(root == null) {
            return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Info leftInfo = Largestbst(root.left);
        Info rightInfo = Largestbst(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, max, min);
        }
        if(leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, max, min);
        }
        return new Info(false, size, max, min);

    }
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left= new Node(45);
        root.right.right= new Node(70);
        root.right.right.left= new Node(65);
        root.right.right.right = new Node(80); 
         Info info = Largestbst(root);
        System.out.println("Largest BST size = "+ maxBST);
    }
}
