package Recursion;

public class basicRecursion {

    // noted-: How to understand & approach a problem ?
    // 1) identify if you can breakdown problem into smaller problems
    // 2) write the recurrencw relation if needed.
    // 3)draw the recus tree
    // 4) ABOUT THE TREE -: 
            // 1) see the flow of function, how they are getting in stack
            // 2)identify and flows of left tree call and right tree calls
            // 3)draw the tree and pointer again and again using pen & paper
            // 4)use a debugger to see how flow works
    // 5) see the values & what type of values
    //  are returned at each step see where the function call willcome out in the end, you will come out of the main function
        
            //recursion - A function that calls itself
        // every function call will take same amount of stack memory , thats why you have to add base case 
        // if not memory will full gives stack overflow
        //and after the each function call execute it goes to where it was called
        
        // why recursion ? 
        //it helps us in solving bigger/complex problems in a simple ways
        //you can convert recursion solution into iteration and vice-versa.
        //space complexity isn't constant bcoz of recursive calls.
        

        static void recursions(int n) {

            //Base condition
            if(n>5){
                return;
            }
            System.out.println(n);

            //recursive call
            //if you are calling a function again and again, you can treat it as a separate call in the stack
            recursions(n+1);
        }

    public static void main(String[] args) {
        // printnum1(1);
        recursions(1);
    }

    static void printnum1(int n) {
        System.out.println(n);
        printnum2(2);
    }

     static void printnum2(int n) {
        System.out.println(n);
        printnum3(3);
    }

     static void printnum3(int n) {
        System.out.println(n);
        printnum4(4);
    }

     static void printnum4(int n) {
        System.out.println(n);
        printnum5(5);
    }
    
     static void printnum5(int n) {
        System.out.println(n);
        }
}
