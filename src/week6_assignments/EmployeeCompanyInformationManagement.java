package week6_assignments;



public class EmployeeCompanyInformationManagement {

    static class Employee {

        String empName;
        double salary;

        static String companyName =
                "Bright Horizon Technologies";

        static int employeeCount = 0;

        Employee(String empName, double salary) {

            this.empName = empName;
            this.salary = salary;

            employeeCount++;
        }

        static void printCompanyInfo() {

            System.out.println(companyName);
            System.out.println(
                    "Employees on record: " + employeeCount
            );
        }
    }

    public static void main(String[] args) {

        Employee employee1 =
                new Employee("Divya", 65000);

        Employee employee2 =
                new Employee("Arjun", 40000);

        Employee employee3 =
                new Employee("Rahul", 55000);

        Employee.printCompanyInfo();
    }
}
