package OOPs.Abstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student{
    // 1.private 2.protected 3.public 4.default-private
    // declare data member
    private int id;
    private String name;
    private String gender;
    private double score1,score2,score3;
    Scanner scan = new Scanner(System.in);

    // constructor
    public Student(){}

    public Student(int id, String name, String gender, double score1, double score2, double score3) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    // method member
    public void addStudent(){
        System.out.print("Enter id        -> "); id = scan.nextInt();
        System.out.print("Enter name      -> "); name = scan.next();
        System.out.print("Enter gender    -> "); gender = scan.next();
        System.out.print("Enter score 1   -> "); score1 = scan.nextDouble();
        System.out.print("Enter score 2   -> "); score2 = scan.nextDouble();
        System.out.print("Enter score 3   -> "); score3 = scan.nextDouble();
    }
    public double total(){
        return  score1 + score2 + score3;
    }
    public double average() {
        return  total() / 3;
    }
    public String grade(){
        return average()<50 ? "F"
                :average()>=50 && average() < 60 ? "E"
                :average()>=60 && average() < 70 ? "E"
                :average()>=70 && average() < 80 ? "E"
                :average()>=80 && average() < 90 ? "E"
                : "A";
    }
    public void display(){
        System.out.println(
                "Student Id         -> "+id+"\n"+
                "Student Name       -> "+name+"\n"+
                "Student Gender     -> "+gender+"\n"+
                "Student Score 1    -> "+score1+"\n"+
                "Student Score 2    -> "+score2+"\n"+
                "Student Score 3    -> "+score3+"\n"+
                "Student Total      -> "+total()+"\n"+
                "Student Average    -> "+average()+"\n"+
                "Student Grade      -> "+grade()
        );
    }
}
public class Test {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student student;
        //
        student = new Student();
        student.addStudent();
        list.add(student); // index = 0;
        //
        student = new Student();
        student.addStudent();
        list.add(student); // index = 1;

        list.get(0).display();
        list.get(1).display();
    }
}
