package DefaultMethod;

public interface Interface2 {
    default void show()
    {
        System.out.println("Default TestInterface2");
    }
}
