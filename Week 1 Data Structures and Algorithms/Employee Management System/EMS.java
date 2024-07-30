public class EMS {
    private Employee[] employees;
    private int size;

    public EMS(int capacity){
        employees=new Employee[capacity];
        size=0;
    }
    public void addEmployee(Employee employee) {
        if (size >= employees.length) {
            System.out.println("Cannot add more employees. Array is full.");
            return;
        }
        employees[size++] = employee;
    }

    public Employee searchEmployee(int employeeId){
        for(int i=0;i<size;i++){
            if(employees[i].getEmployeeId()==employeeId){
                return employees[i];
            }
        }
        return null;
    }
    
    public void traverseEmployees(){
        for(int i=0;i<size;i++){
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployeeById(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[--size] = null; // Clear the last reference
    }

    public static void main(String[] args) {
        EMS system = new EMS(10);

        // Adding employees
        system.addEmployee(new Employee(1, "John Doe", "Developer", 75000));
        system.addEmployee(new Employee(2, "Jane Smith", "Manager", 85000));
        system.addEmployee(new Employee(3, "Emily Davis", "Analyst", 65000));

        // Traverse employees
        System.out.println("All Employees:");
        system.traverseEmployees();

        // Search for an employee
        System.out.println("\nSearching for employee with ID 2:");
        Employee employee = system.searchEmployee(2);
        System.out.println(employee);

        // Delete an employee
        System.out.println("\nDeleting employee with ID 2:");
        system.deleteEmployeeById(2);

        // Traverse employees after deletion
        System.out.println("All Employees after deletion:");
        system.traverseEmployees();
    }
}
