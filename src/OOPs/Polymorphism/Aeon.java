package OOPs.Polymorphism;

abstract class Discount{
    abstract int getDiscount();
}
public class Aeon extends Discount{
    @Override
    int getDiscount() {
        return 20;
    }

    public static void main(String[] args) {
        Aeon aeon = new Aeon();
        System.out.println("Discount is "+aeon.getDiscount()+" % ");
    }
}
