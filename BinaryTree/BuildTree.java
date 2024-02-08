package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {
     static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
     }
     static class InnerBuildTree {
        static int idx = -1;
        public static Node buildT(int node[]) {
            idx++;
            if(node[idx] == -1) {
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.left = buildT(node);
            newNode.right = buildT(node);
            return newNode;
        }
     
     //PREORDER TREE TRAVERSAL [root -> left -> right]

     public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     }

     //INORDER TREE TRAVERSAL [LEFT -> ROOT -> RIGHT]
    
     public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.data + " ");
        preOrder(root.right);
     }

     //POSTORDER TREE TRAVERSAL [RIGHT -> LEFT -> ROOT]

     public static void postOrder(Node root) {
        if(root == null) {
            return;
        }
        preOrder(root.right);
        preOrder(root.left);
        System.out.print(root.data + " ");
     }

     //LEVELORDER TREE TRAVERSAL [1ST -> 2ND ->3RD ...]
     
     public static void levelOrder(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currentNode = q.remove();
            if(currentNode == null) {
                System.out.println();
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
              System.out.print(currentNode.data+" ");
              if(currentNode.left != null) {
                q.add(currentNode.left);
              }

            }
              if(currentNode.right != null) {
                q.add(currentNode.right);
        }
        }
     }

    }
     public static void main(String[] args) {
        int node[] = {9,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        InnerBuildTree tree = new InnerBuildTree();
        Node root = tree.buildT(node);
        // System.out.println(root.data);

        tree.levelOrder(root);
     }
}
