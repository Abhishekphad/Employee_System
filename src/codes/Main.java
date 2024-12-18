package codes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import codes.EmployeeManagementSystem;

public class Main {
	public static void main(String[] args) {
		System.out.println("Employee Management System");
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1. Add Employee ");
			System.out.println("2. Update Employee ");
			System.out.println("3. Delete Employee ");
			System.out.println("4. View All Employees ");
			System.out.println("5. Search Employees ");
			System.out.println("6. Search Employees by Department");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
			
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1 : 
				System.out.println("Enter id: ");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter name: ");
				String name=sc.nextLine();
				System.out.println("Emter dept: ");
				String dept=sc.nextLine();
				System.out.println("Enter Salary: ");
				double salary= sc.nextDouble();
				Employee newEmployee = new Employee(id, name, dept, salary);
				EmployeeManagementSystem.addEmployee(newEmployee);
                break;
                
			case 2 :
				 System.out.print("Enter Employee ID to update: ");
                 int updateId = sc.nextInt();
                 sc.nextLine();
                 System.out.print("Enter new Name: ");
                 String updateName = sc.nextLine();
                 System.out.print("Enter new Department: ");
                 String updateDepartment = sc.nextLine();
                 System.out.print("Enter new Salary: ");
                 double updateSalary = sc.nextDouble();
                 EmployeeManagementSystem.updateEmployee(updateId, updateName, updateDepartment, updateSalary);
                 break;
                 
			case 3 :
				System.out.print("Enter Employee ID to delete: ");
                int deleteId = sc.nextInt();
                EmployeeManagementSystem.deleteEmployee(deleteId);
                break;
                
			case 4:
				EmployeeManagementSystem.viewAllEmployees();
                break;
                
			case 5:
				sc.nextLine(); 
                System.out.print("Enter Employee Name to search: ");
                String searchName = sc.nextLine();
                EmployeeManagementSystem.searchEmployeeByName(searchName);
                break;
                
			case 6:
				sc.nextLine();  
                System.out.print("Enter Department to search: ");
                String searchDept = sc.nextLine();
                EmployeeManagementSystem.searchEmployeeByDepartment(searchDept);
                break;
                
			case 7:
                System.out.println("Exiting the system...");
                sc.close();
                System.exit(0);
			}
		}
		
	}
}
	
//Employee Management System
//Description: A system to manage employee records. Users can add, update, delete, view, and search employee details.
//
//Modules:
//
//-Add Employee: Insert details like ID, name, department, designation, and salary.
//-Update Employee: Update employee details based on ID.
//-Delete Employee: Remove an employee by ID.
//-View All Employees: Display the list of employees.
//-Search Employees: Search employees by name or department.