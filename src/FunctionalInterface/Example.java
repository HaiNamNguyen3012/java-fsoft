package FunctionalInterface;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example  {

    public static void main(String[] args) {
        // In ra chữ hoa
        List<String> result = Stream.of("Goku", "Vegata", "Pic", "To")
                .filter(s -> {
                    System.out.println("[filtering] " + s);
                    return s.length()>=4;
                })
                .map(s -> {
                    System.out.println("[mapping] " + s);
                    return s.toUpperCase();
                })
                .collect(Collectors.toList());
        System.out.println("Result:");
        result.forEach(System.out::println);
    }
}
