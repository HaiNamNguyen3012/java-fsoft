package Bai5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Hotel {
    private List<Person> persons;

    public Hotel() {
        persons = new ArrayList<>();
    }

    public void add(Person person) {
        this.persons.add(person);
    }

    public boolean delete(String passport) {
        Optional<Person> person = this.persons.stream()
                .filter(p -> p.getPassport().equals(passport))
                .findFirst();

        person.ifPresent(this.persons::remove);

        return person.isPresent();
    }

//    public int calculator(String passport) {
//        int result;
//         this.persons.stream().filter(p -> p.getPassport().equals(passport))
//                .findFirst()
//                .isPresent( p -> result = p.getRoom().getPrice() * person.getNumberRent());
//        if (person == null) {
//            return 0;
//        }
//        return person;
//    }

    public void show() {
        this.persons.forEach(p -> System.out.println(p.toString()));
    }
}
