package com.company;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

public class Main {

    public static void main(String[] args) {
        List<Human> humans = List.of(
                new Human(19, "Ivan", "Vasiliev", LocalDate.of(2002, 12, 14), 60),
                new Human(56, "Vladilen", "Petrov", LocalDate.of(1965, 1, 3), 53),
                new Human(24, "Serj", "Tankian", LocalDate.of(1997, 7, 22), 57),
                new Human(32, "Sergei", "Erokhin", LocalDate.of(1989, 9, 15), 80),
                new Human(21, "Dmitriy", "Simonyan", LocalDate.of(2000, 4, 2), 46)
        );

        int i = humans.stream().sorted(Comparator.comparing(human -> human.getLastName().substring(human.getLastName().length() - 1)))
                .peek(System.out::println)
                .filter(human -> human.getAge() > human.getWeight())
                .peek(System.out::println)
                .sorted(Comparator.comparing(Human::getBirthDate))
                .peek(System.out::println)
                .mapToInt(Human::getAge)
                .reduce((left, right) -> left * right).orElse(0);

        System.out.println(i);
    }
}
