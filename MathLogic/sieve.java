package MathLogic;

public class sieve {
    //TIME COMPLEXITY = O(N*LOG(LOGN))//

    //GOAL : 1 CORER DEVLOPER JOB WITH 1DEC
    //PLAN :
    //a : Data structure & Algorithum
    //b : leetcode Question pratice
    //c : Web Devlopement
    //d : Project
    //e : building profile + Resume
    //f : Applying for jobs
    //g : theory concept + aptitude
    public static void main(String[] args) {
        int n=40;
        boolean[] primes =new boolean[n+1];
        IsPrime(n, primes);
    }

    //false in array means number is prime
    static void IsPrime(int n, boolean[] primes) {
        for(int i=2; i*i<=n; i++) {
            if(!primes[i]) {
                for(int j = i*2; j<=n; j+=i) {
                    primes[j] = true;
                }
            }
        }
        for(int i=2; i<=n; i++) {
            if(!primes[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
