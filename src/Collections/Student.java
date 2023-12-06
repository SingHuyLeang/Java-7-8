package Collections;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private String gender;
    private double score1;
    private double score2;
    private double score3;

    Scanner scan = new Scanner(System.in);

    public Student() {}

    public Student(int id, String name, String gender, double score1, double score2, double score3) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    public int getId() {
        return id;
    }

    public void addStudent(){
        System.out.print("Enter student id : "); id   = scan.nextInt();
        System.out.print("Enter name       : "); name = scan.next();
        System.out.print("Enter gender     : "); gender = scan.next();
        System.out.print("Enter score 1    : "); score1 = scan.nextDouble();
        System.out.print("Enter score 2    : "); score2 = scan.nextDouble();
        System.out.print("Enter score 3    : "); score3 = scan.nextDouble();
    }
    public double total(){
        return score1 + score2 + score3;
    }
    public double average(){
        return total() / 3;
    }

    public String grade(){
        return average()<50 ? "F"
                :average()>=50 && average() < 60 ? "E"
                :average()>=60 && average() < 70 ? "E"
                :average()>=70 && average() < 80 ? "E"
                :average()>=80 && average() < 90 ? "E"
                : "A";
    }

    // កាត់ក្បៀស
    DecimalFormat df = new DecimalFormat("######0.00");

    public void showStudent(){
        System.out.println(
                "\t"+id+
                "\t"+name+
                "\t"+gender+
                "\t"+score1+
                "\t"+score2+
                "\t"+score3+
                "\t"+total()+
                "\t"+df.format(average())+
                "\t"+grade()
        );
    }
    public void header(){
        System.out.println("\tId\tName\tGender\tScore1\tScore2\tScore3\tTotal\tAverage\tGrade");
    }
}
