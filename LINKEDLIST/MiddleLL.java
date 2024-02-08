package LINKEDLIST;

//Q:876
// https://leetcode.com/problems/middle-of-the-linked-list/

public class MiddleLL {
   
    public static void main(String[] args) {
        
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
