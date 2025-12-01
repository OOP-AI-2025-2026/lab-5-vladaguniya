package ua.opnu;

public class Main {
    public static void main(String[] args) {
        Person[] people = {
                new Student("Петренко", "Іван", 20, "IT-21", "KB12345678"),
                new Lecturer("Іванов", "Петро", 45, "Комп'ютерних наук", 25000.0),
                new Person("Сидоренко", "Марія", 30),
                new Student("Коваленко", "Анна", 19, "ЕК-12", "KB87654321"),
                new Lecturer("Захаренко", "Ольга", 52, "Прикладної математики", 32000.0)
        };

        System.out.println("--- Список людей в масиві ---");

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
