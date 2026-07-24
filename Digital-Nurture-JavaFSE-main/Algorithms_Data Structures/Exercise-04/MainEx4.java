public class MainEx4 {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        Employee e1 = new Employee("E001", "Alice", "Developer", 75000);
        Employee e2 = new Employee("E002", "Bob", "Manager", 85000);
        Employee e3 = new Employee("E003", "Charlie", "Analyst", 65000);

        // Add
        ems.addEmployee(e1);
        ems.addEmployee(e2);
        ems.addEmployee(e3);

        // Traverse
        ems.traverseEmployees();

        // Search
        System.out.println("Searching for E002...");
        Employee found = ems.searchEmployee("E002");
        if (found != null) {
            System.out.println("Found: " + found);
        }

        // Delete
        ems.deleteEmployee("E002");
        
        // Traverse after deletion
        ems.traverseEmployees();
    }
}
