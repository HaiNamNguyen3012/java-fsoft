package DefaultMethod;

public class Main implements Interface1, Interface2{
    public void show()
    {
        // use super keyword to call the show
        // method of TestInterface1 interface
        Interface1.super.show();

        // use super keyword to call the show
        // method of TestInterface2 interface
        Interface2.super.show();
    }
    public static void main(String args[])
    {
        Main d = new Main();
        d.show();
    }
}
