package code.Nira.BinaryTress;
class Node {
    int data;
    Node left,right;

    Node(int data) {
        this.data = data;
    }
}
class Res {
    public int val;
}
public class MaxiPath {
  Node root;
  int FindMaxUtill(Node node, Res res) {
    if(node == null) {
        return 0;
    }
        int i = FindMaxUtill(node.left, res);
        int j = FindMaxUtill(node.right, res);

        int max_single = Math.max(Math.max(i, j) + node.data, node.data);
        int max_top = Math.max(max_single,i+j+node.data);
        res.val = Math.max(res.val, max_top);
        return max_single;
  }

  int FindMaxSum() {
    return FindMaxSum(root);
  }

  int FindMaxSum(Node node) {
    Res.res = new Res();
    res.val = Integer.MIN_VALUE;
    FindMaxUtill(node, res);
    return res.val;
  }
    
    public static void main(String[] args) {
        MaxiPath tree = new MaxiPath();
        tree.root = new Node
    }
}
