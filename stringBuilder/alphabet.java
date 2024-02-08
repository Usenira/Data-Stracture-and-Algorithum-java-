package stringBuilder;

public class alphabet {
    public static void main(String[] args) {

        // String str = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            // str = str + ch;// it takes n2 time so thats why we use stringbuilder instead of string

            sb.append(ch);// this takes o(n) time cuz its don't creat new object everytime here its only do operation with the same object
            

        }
        System.out.println(sb.toString());

    }
}
