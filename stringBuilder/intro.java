package stringBuilder;

import java.util.ArrayList;

public class intro {
    public static void main(String[] args) {
        String a = "kunal";
        String b = a;  //here the variable a and b are pointing to the "kunal" value

        System.out.println(b == a);//true [== /its a comparator]
   
        String name1 = new String("kunal"); // creating object // syntex - datatype variable-Name = new dataType("value");
        String name2 = new String("kunal");

        System.out.println(name1 == name2); // false because here both variable pointing to different
        System.out.println(name1.equals(name2)); // here .equals() its a method who check values of two different object

        //from today 14th/sept/2023 i decide to change mySelf complete because i can't live a life which full regrets have no money + skill.
        //i don't want to  live a below average life that's why i need to work 
        // do everyday spend 8hr to learn skill
        //no distraction
        //no pornography
        //no reels + movies
        //
        //Discipline towards my daily work
        //consistency
        //just work work and work
        // no one can come to save you  only you can so so get hard and curious everything comes at a cost 
        //the most interest superpower is to change yourself stay hard

        System.out.println('a' + 'b'); // output - 196
        System.out.println("a" + "b"); // output - ab
        System.out.println((char)('a' + 3));//it converted into char

        System.out.println("a" + 1);// o - a1
        //integer will be converted to Integer that will call toString

        System.out.println("kunal" + new ArrayList<>());
        System.out.println("kunal" + new Integer(78));
        // System.out.println(new Integer(67) + new ArrayList<>());// concatination '+' this is only used by premitive datatype
        //  or one of them is String class

        String str = "kunal";
        System.out.println(Arrays.toString(str.toCharArray()));// output- [k,u,n,a,l];
    }
}
