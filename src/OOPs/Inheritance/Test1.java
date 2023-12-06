package OOPs.Inheritance;

import java.util.Scanner;

public class Test1 {

    // Data Member in Class Test 1
    protected int x;
    protected int y;
    protected int z;
    // Constructor in Class Test 1
    public Test1(){
        x = 100;
        y = 200;
        z = 300;
    }

    public Test1(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Scanner scan = new Scanner(System.in);

    // Method Member in Class Test 1
    public void input(){
        System.out.print("Enter x = "); x = scan.nextInt();
        System.out.print("Enter y = "); y = scan.nextInt();
        System.out.print("Enter z = "); z = scan.nextInt();
    }
    public void output() {
        System.out.println("X = " + x);
        System.out.println("Y = " + y);
        System.out.println("Z = " + z);
    }
}

