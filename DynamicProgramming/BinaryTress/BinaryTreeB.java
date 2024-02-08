package code.Nira.BinaryTress;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeB {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree {
        static int idx = -1;
        public static Node BuiltTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }

            Node newNode  = new Node(nodes[idx]);
            newNode.left = BuiltTree(nodes);
            newNode.right = BuiltTree(nodes);
            return newNode;
        }
        public static void preorder(Node root) {
            if(root == null) {
                return;
            }
           System.out.print(root.data+" ");
            preorder(root.left);
           preorder(root.right);
        }
        

        public static void inorder(Node root) {
            if(root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if(root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data+" ");
        }

        public static void Levelorder(Node root) {
            if(root == null) {
                return;
            }

            Queue<Node> Q = new LinkedList<>();
            Q.add(root);
            Q.add(null);

            while (!Q.isEmpty()) {
                Node CurrNode = Q.remove();
                if(CurrNode == null) {
                    System.out.println();
                    if(Q.isEmpty()) {
                        break;
                    } else {
                        Q.add(null);
                    } 
                } else {
                    System.out.print(CurrNode.data+" ");
                    if(CurrNode.left != null) {
                        Q.add(CurrNode.left);
                    }
                    if(CurrNode.right != null) {
                        Q.add(CurrNode.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int node[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = BinaryTree.BuiltTree(node);
        BinaryTree.preorder(root);
        System.out.println();
        BinaryTree.inorder(root);
        System.out.println();
        BinaryTree.postorder(root);
        System.out.println();
        BinaryTree.Levelorder(root);
    }
}
