package sixteen;

/**
 * 1.Records can have static field but no instance fields
 * 2.Records are final & can not be extended
 */

public record Employee(String name, String gender, int age) {
    static final int count = 10;

    public static void main(String[] args) {
        Employee employee = new Employee("Ram", "Male", 34);
        System.out.println(employee);
        System.out.println(Employee.count);
    }
}