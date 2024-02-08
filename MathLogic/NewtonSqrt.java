//NEWTON'S RAPSION METHOD (SQUARE ROOT)// time complexity : O((logn)*f(n))
 // here f(n) = cost or complexity of calculating f(n)/f^(n) with some n- digit procion
 //formula : root = (x+n/x)/2 / // error : root-x;
package MathLogic;

//pending work :
//a: revision of dsa 
//b: math 1

public class NewtonSqrt {
    public static void main(String[] args) {
        
        System.out.println(sqrt(40));
    }

    static double sqrt(double n) {
        double x = n;

        double root;
        while (true) {
             root = 0.5* (x+ (n/x));
            if (Math.abs(root-x) < .5) {
                break;
            }
            x = root;
        }
        return root;
    } 
}
