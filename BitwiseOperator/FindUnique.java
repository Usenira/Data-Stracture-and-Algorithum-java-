package BitwiseOperator;

public class FindUnique {
    public static void main(String[] args) {
        int[] arr = {2,3,4,2,3,7,4};
        System.out.println(ans(arr));
    }
    static int ans(int[] arr) {
        int unique =0;
        for (int i : arr) {
            unique ^= i;
        }
        return unique;
    }
}
