package Assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFinder {

    static class Employee {
        int id;
        String name;
        double salary;
        String skill;

        public Employee(int id, String name, double salary, String skill) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.skill = skill;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    ", skill='" + skill + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Shreya", 50000, "Java"));
        employees.add(new Employee(2, "Shravya", 60000, "Python"));
        employees.add(new Employee(3, "Anvitha", 55000, "Java"));
        employees.add(new Employee(4, "Nischitha", 52000, "Python"));

        List<Employee> pythonEmployees = employees.stream()
                .filter(employee -> "Python".equals(employee.skill))
                .collect(Collectors.toList());

        if (pythonEmployees.isEmpty()) {
            throw new RuntimeException("No employees with skill Python");
        } else {
            System.out.println("Employees with skill Python:");
            pythonEmployees.forEach(System.out::println);
        }
    }
}
