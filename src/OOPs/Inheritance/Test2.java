package OOPs.Inheritance;

import java.util.Scanner;

public class Test2 extends Test1 {
    public Test2(){
        super(); // ទៅចាប់យក Default Constructor មកពី Class Test1
    }

    public Test2(int x, int y, int z) {
        super(x, y, z); // ទៅចាប់យក Constructor has parameter មកពី Class Test1
    }
    public void input(){
        super.input(); // ទៅ Override Method input មកពី Class Test1
    }
    public void output(){
        super.output(); // ទៅ Override Method output មកពី Class Test1
    }
}
