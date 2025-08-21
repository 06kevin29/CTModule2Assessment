import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", 25, 50000),
                new Employee("Bob", 30, 60000),
                new Employee("Charlie", 28, 55000),
                new Employee("Diana", 35, 75000),
                new Employee("Ethan", 40, 90000)
        );

        List<Employee> greaterThan50K = employees.stream()
                .filter(employee -> employee.getSalary() > 50000 )
                .toList();
        System.out.println("Employees with a salary greater than $50K: " + greaterThan50K);

        double averageSalary30Plus = employees.stream()
                .filter(employee -> employee.getAge() >= 30)
                .mapToDouble(Employee::getSalary)
                .average().orElse(0);
        System.out.println("Employees older than 30's average salary: " + averageSalary30Plus);

        List<Employee> updatedSalaries = employees.stream()
                .map(emp -> new Employee(
                        emp.getName(),
                        emp.getAge(),
                        emp.getSalary() * 1.10))
                .toList();
        System.out.println("Employees with 10% increase to salary: " + updatedSalaries);

    }
}
