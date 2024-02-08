package Recursion;

public class SubSequence {
    
    public static void main(String[] args) {
        String up = "abcapplecad";
        skip(" ", up);
        System.out.println(skipApple(up));
        System.out.println(skipAppNotApple("abcappleknappmk"));
    }

    static void skip(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        if(ch == 'a') {
            skip(p, up.substring(1));
        }else {
            skip(p+ch, up.substring(1));
        }
    }


        static String skips(String up) {
        if(up.isEmpty()) {
            return " ";
        }

        char ch = up.charAt(0);
        if(ch == 'a') {
           return skips(up.substring(1));
        }else {
           return ch + skips(up.substring(1));
        }
    }
    
     static String skipApple(String up) {
        if(up.isEmpty()) {
            return " ";
        }

        if(up.startsWith("apple")) {
           return skipApple(up.substring(5));
        }else {
           return  up.charAt(0) + skipApple(up.substring(1));
    }
}

// start with app but its not apple then skip the app
static String skipAppNotApple(String up) {
        if(up.isEmpty()) {
            return " ";
        }

        if(up.startsWith("app") && !up.startsWith("apple")) {
           return skipAppNotApple(up.substring(3));
        }else {
           return  up.charAt(0) + skipAppNotApple(up.substring(1));
    }

}
}
