package ru.aston.hometask;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Тимофей", List.of(
                        new Book("Java 8", 400, 2015),
                        new Book("Effective Java", 350, 2008),
                        new Book("Clean Code", 450, 2008),
                        new Book("Spring in Action", 500, 2016),
                        new Book("Head First Java", 700, 2003)
                )),
                new Student("Елена", List.of(
                        new Book("Java Concurrency", 300, 2010),
                        new Book("Hibernate", 250, 2005),
                        new Book("Design Patterns", 350, 1994),
                        new Book("Refactoring", 400, 1999),
                        new Book("Thinking in java", 200, 2003)
                ))
        );

        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Найдена книга, год выпуска: " + year),
                        () -> System.out.println("Книга не найдена")
                );
    }
}