package LINKEDLIST;

public class DoubelyLL {
    public static void main(String[] args) {
        DoubelyLL list = new DoubelyLL();
        list.insertFirst(1);
        list.insertFirst(7);
        list.insertFirst(8);
        list.insertFirst(89);
        list.insertFirst(86);
        list.insertFirst(45);
        // list.insertinIndex(90, 3);
        list.insertmid(7, 56);
        list.Display();
    }

    private Node head;
    private Node tail;
    private int size;

    public DoubelyLL() {
        this.size = 0;
    }

    //ADD FIRST NODE TO DOUBELLY LINKEDLIST
    public void insertFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        newNode.prev = null;
        if(head != null) {
        head.prev = newNode;
        }
        head = newNode;
    }
    
    //DISPLAY METHOD WE WRITE TO PRINT THE DOUBELLY LINKEDLIST
    public void Display() {
        Node temp = head;
        Node last = null;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            last = temp;
            temp = temp.next;
            // last = temp; // this gives only END coz its pointing to the last null node
        }
        System.out.println("END");

        while (last != null) {
            System.out.print(last.value+" -> ");
            last = last.prev; 

        }
        System.out.println("END");
    }


    //Insert in last 
    public void InsertLast(int val) {
        Node node  = new Node(val);
        Node last = head;

        node.next = null;


        if(head == null) {
            node.prev = null;
            head = node;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
    }

    //INSERT at Particular index
    public void insertinIndex(int val, int index) {
        if(index == 0) {
            insertFirst(index);
            return;
        }
        if(index == size) {
            InsertLast(index);
            return;
        }

        Node temp = head;
        for(int i=0; i<index;i++) {
            temp = temp.next;
        }
        Node newNode = new Node(val, temp.next);
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        if(newNode.next != null) {
        newNode.next.prev = newNode;
    }
}
//finding Node
  public Node find(int val) {
    Node node = head;
    while (node != null) {
        if(node.value == val) {
            return node;
        }
       node = node.next;
    }
    return null;
  }

  public void insertmid(int after, int val) {
    Node p = find(val);
    
    if(p == null) {
        System.out.println("does not exist");
        return;
    }

    Node node = new Node(val);
    node.next = p.next;
    p.next = node;
    node.prev = p;
    if(node.next != null) {
        node.next.prev = node;
    }
  }
    private class Node{
        int value;
        Node next;
        Node prev;

        public Node (int value){
            this.value = value;
        }
         public Node(int value,Node next) {
            this.value = value;
            this.next = next;
        }


        public Node(int value,Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
