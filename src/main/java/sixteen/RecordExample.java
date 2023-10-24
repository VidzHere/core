package sixteen;

public class RecordExample {

    public static void main(String[] args) {
        Person ram = new Person("Ram", "Male", 32);
        Person sita = new Person("Siita", "Female", 30);
        System.out.println("name -> " + ram.name() + "  age -> " + ram.age() + "  gender -> " + ram.gender());
        System.out.println("name -> " + sita.name() + "  age -> " + sita.age() + "  gender -> " + sita.gender());
    }
}