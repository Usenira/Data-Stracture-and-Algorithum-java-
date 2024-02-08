package JAVABOOTCAMP.OOPS;

public class main {
    
    public static void main(String[] args) {

    Student[] students = new Student[5];

    Student kunal = new Student(34, "Niranjana", 89.6f); // kunal is the reference variable in stack memory refer to the heap memory
    // System.out.println(kunal);// this gives address of the object which is stored in the heap memory
    
    }

}

//create a class
//for every single student
//A class have properties and methods
class Student{
    //these are the property 
    int roll;
    String name;
    float marks;



    // Student (int roll,String name, float marks) {
    //     this.roll = roll;
    //     this.name = name;
    //     this.marks = marks;
    // }
}