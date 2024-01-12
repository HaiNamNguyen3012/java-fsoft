package Dahinh;

public class Dog  extends  Animal{
    public Dog(int speed) {
        super(speed);
    }
    void run(){System.out.println("Dog can run upto 60km/h");}
    public static void main(String[] args) {
        Animal a = new Dog(60);
        a.run();
    }
}
