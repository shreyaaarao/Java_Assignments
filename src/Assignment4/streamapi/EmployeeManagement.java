package Assignment4.streamapi;

import java.util.*;
import java.util.stream.*;

class Employee {
    private String name;
    private int age;
    private int experience;
    private double salary;
    private String department;

    public Employee(String name, int age, int experience, double salary, String department) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}

public class EmployeeManagement {

    public static void main(String[] args) {
        // Creating a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 30, 5, 50000, "Sales"));
        employees.add(new Employee("Alice", 25, 3, 45000, "HR"));
        employees.add(new Employee("Bob", 35, 8, 60000, "IT"));
        employees.add(new Employee("Emily", 28, 6, 55000, "Sales"));

        // Total number of employees in the company
        long totalEmployees = employees.stream().count();
        System.out.println("Total number of employees: " + totalEmployees);

        // Grouping the employees based on department
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Employees grouped by department: " + employeesByDepartment);

        // Total salary paid to all employees
        double totalSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("Total salary paid to all employees: " + totalSalary);

        // Total salary paid to employees of each department
        Map<String, Double> totalSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
        System.out.println("Total salary paid to employees of each department: " + totalSalaryByDepartment);

        // Sorting employees based on age
        List<Employee> employeesSortedByAge = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toList());
        System.out.println("Employees sorted by age: " + employeesSortedByAge);

        // Sorting employees based on experience
        List<Employee> employeesSortedByExperience = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getExperience))
                .collect(Collectors.toList());
        System.out.println("Employees sorted by experience: " + employeesSortedByExperience);

        // Finding the country with the longest name from a list of countries
        List<String> countries = Arrays.asList("United States", "United Kingdom", "Canada", "Australia", "India");
        String countryWithLongestName = countries.stream()
                .reduce((country1, country2) -> country1.length() > country2.length() ? country1 : country2)
                .orElse(null);
        System.out.println("Country with the longest name: " + countryWithLongestName);
    }
}

