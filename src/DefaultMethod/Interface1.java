package DefaultMethod;

public interface Interface1 {
    default void show()
    {
        System.out.println("Default TestInterface1");
    }
}
