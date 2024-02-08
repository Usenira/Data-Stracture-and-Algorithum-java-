package code.Nira.Stacks;

import java.util.Stack;

public class GreatestElement {
public static void main(String[] args) {
    int arr[] = {6,8,0,1,3};

    Stack<Integer> Stacks = new Stack<>();
    int Greatest[] = new int[arr.length];
    for (int i = arr.length-1; i >= 0; i--) {
        while (!Stacks.isEmpty() && arr[i]>=arr[Stacks.peek()]) {
            Stacks.pop();
        }
        if(Stacks.isEmpty()) {
            Greatest[i] = -1;
        } else {
            Greatest[i] = arr[Stacks.peek()];
        }
        Stacks.push(i);
    }
    for (int i = 0; i < Greatest.length; i++) {
        System.out.print( Greatest[i]+" ");
    }
    System.out.println();
}    
}
