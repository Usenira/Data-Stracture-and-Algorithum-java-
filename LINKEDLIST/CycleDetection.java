package LINKEDLIST;

public class CycleDetection {

    private Node head;
    private Node tail;
    public static void main(String[] args) {
        
        CycleDetection list = new CycleDetection();
        list.
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

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    //write ListNode class + Display + head +tail pionter

    //  approach: fast && slow pointer method
    // if cycle is present return true or false

    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false; 
    }

    public int cycleLength(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                Node temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while(temp != slow);
                 return length;
            } 
    }
     return 0;
}

//142 Question : find starting Node of the cycle in linkedlist
public Node detectCycle(Node head) {
    int length = 0;


    Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
               length = cycleLength(slow);
               break;
            }
        }
        //if no cycle is present then return null
        if(length == 0) {
            return null;
        }

        //find the start node
        Node f = head;
        Node s = head;
        while (length > 0) {
            s = s.next;
            length--;
        }

        //keep moving both forward and they will meet at cycle start
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
}

// Q: 202 write an algorithum to determine if a number is happy the return true or false

}
