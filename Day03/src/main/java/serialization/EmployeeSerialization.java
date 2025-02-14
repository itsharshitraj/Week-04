package serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Employee class implementing Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Version control for serialization

    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Override toString() for easy display
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: $" + salary;
    }
}

// Main class for serialization and deserialization
public class EmployeeSerialization {
    private static final String FILE_NAME = "src/main/java/serialization/employees.ser";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = loadEmployeesFromFile();  // Load existing employees

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Save Employees to File");
            System.out.println("3. Load Employees from File");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add new employee
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();

                    employees.add(new Employee(id, name, department, salary));
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    // Serialize employee list to file
                    saveEmployeesToFile(employees);
                    break;

                case 3:
                    // Deserialize and display employees
                    employees = loadEmployeesFromFile();  //  Update list in memory
                    if (!employees.isEmpty()) {
                        System.out.println("\\ Employees from file:");
                        for (Employee emp : employees) {
                            System.out.println(emp);
                        }
                    } else {
                        System.out.println(" No employees found in file.");
                    }
                    break;

                case 4:
                    // Exit the program
                    System.out.println(" Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println(" Invalid choice. Please try again.");
            }
        }
    }

    // Serialize and save the list of employees
    private static void saveEmployeesToFile(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            oos.flush(); //  Ensures data is written before closing
            System.out.println(" Employees saved successfully!");
        } catch (IOException e) {
            System.out.println(" Error saving employees: " + e.getMessage());
        }
    }

    // Deserialize and load employees from file
    @SuppressWarnings("unchecked")
    private static List<Employee> loadEmployeesFromFile() {
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println(" No previous employee data found. Starting fresh.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" Error loading employees: " + e.getMessage());
        }

        return new ArrayList<>();
    }
}
