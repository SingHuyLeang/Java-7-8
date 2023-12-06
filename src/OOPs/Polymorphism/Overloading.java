package OOPs.Polymorphism;
class First{
    public void add(int a,int b){
        System.out.println("a : "+a);
        System.out.println("b : "+b);
    }
}
public class Overloading extends First{
    @Override
    public void add(int a, int b) {
        super.add(a, b);
    }

    public static void main(String[] args) {
        Overloading overload = new Overloading();
        overload.add(10,20);
    }
}
