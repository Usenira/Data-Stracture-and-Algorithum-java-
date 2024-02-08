package code.Nira.Stacks;


import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;;
public class nira {
    
    public static void main(String[] args) {
        // Stack<Integer> s1 = new Stack<>();

        // s1.push(1);
        // s1.push(2);
        // s1.push(3);
        // s1.push(4);
        // s1.push(5);
        // s1.push(6);

        // System.out.println(s1.pop());
        // System.out.println(s1.pop());
        // System.out.println(s1.pop());
        // System.out.println(s1.pop());
        // System.out.println(s1.pop());

        Queue<Integer> Q1 = new LinkedList<>();
        Q1.add(12);
        Q1.add(112);
        Q1.add(1112);
        Q1.add(11112);
        Q1.add(111112);
        Q1.add(1111112);
        
        System.out.println(Q1.remove());
        System.out.println(Q1.remove());
        System.out.println(Q1.remove());
    }
}
