package BinaryTree;

public class MaximumPath {
    
    public static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    class Res {
        public int val;
    }
     int findMaxUtil(Node node, Res res) {
            if(node == null) {
                return 0;
        }
        int l = findMaxUtil(node.left, res);
        int r = findMaxUtil(node.right, res);

        int max_single = Math.max(Math.max(l, r)+ node.data, node.data);
        
        int max_top = Math.max(max_single, l+r+node.data);

        res.val = Math.max(res.val, max_top);

        return max_single;
    }

     int findMaxSum() {
        return findMaxSum(root);
    }

     int findMaxSum(Node node) {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;

        findMaxUtil(node, res);
        return res.val;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);
        System.out.println("Maximum path sum is:" + findMaxSum(root));


    }
}
