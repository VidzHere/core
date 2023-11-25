package sixteen;


public class MultipleRecordsExample {
    public static void main(String[] args) {
        Person person = new Person("Ram Kumar", 30, new Address("333 Market Street", "SFO"));
        System.out.println("Name: " + person);
    }

    record Person(String name, int age, Address address) {
    }

    record Address(String street, String city) {
    }
}
