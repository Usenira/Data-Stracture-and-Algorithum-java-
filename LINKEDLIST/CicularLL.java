package LINKEDLIST;

public class CicularLL {
    public static void main(String[] args) {
        CicularLL list = new CicularLL();
        list.insert(98);
        list.insert(76);
        list.insert(97);
        list.insert(43);
        list.insert(56);
        list.deleteNode(43);
        list.Display();
        
    }
    private Node head;
    private Node tail;

    public CicularLL() {
        this.head = null;
        this.tail = null;
    }
    public void insert(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void Display() {
        Node node = head;
        if(head != null) {
            do {
                System.out.print(node.value + " -> ");
                node = node.next;
            } while(node != head);
        }
        System.out.println("HEAD");
    }


    public void deleteNode(int val) {
        Node node = head;
        if(node == null) {
            return;
        }

        if(node.value == val) {
            head = head.next;
            tail.next = head; 
            return;
        }

        do {
            Node n = node.next;
            if(n.value == val) {
                node.next = n.next;
                break;
            }
            node = node.next;
        } while(node != head);
    }

    private class Node {
        private int value;
        private Node next;
    
        public  Node(int value) {
            this.value = value;
        }
    
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
