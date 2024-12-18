package codes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeManagementSystem {
	 private static Connection con;

	    // Constructor to initialize the connection
	    static {
	        try {
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "root");
	            System.out.println("Database connected successfully.");
	        } catch (SQLException e) {
	            System.out.println("Connection failed: " + e.getMessage());
	        }
	    }

	    // Add Employee to the database
	    public static void addEmployee(Employee employee) {
	        String query = "INSERT INTO employees (id,name, department, salary) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement ps = con.prepareStatement(query)) {
	        	ps.setInt(1, employee.getId());
	            ps.setString(2, employee.getName());
	            ps.setString(3, employee.getDept());
	            ps.setDouble(4, employee.getSalary());
	            ps.executeUpdate();
	            System.out.println("Employee added successfully!");
	        } catch (SQLException e) {
	            System.out.println("Failed to add employee: " + e.getMessage());
	        }
	    }

	    // Update Employee in the database
	    public static void updateEmployee(int id, String name, String department,  double salary) {
	        String query = "UPDATE employees SET name = ?, department = ?,  salary = ? WHERE id = ?";
	        try (PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setString(2, name);
	            ps.setString(3, department);
	            ps.setDouble(4, salary);
	            ps.setInt(1, id);
	            int updatedRows = ps.executeUpdate();
	            if (updatedRows > 0) {
	                System.out.println("Employee updated successfully!");
	            } else {
	                System.out.println("Employee not found.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Failed to update employee: " + e.getMessage());
	        }
	    }

	    // Delete Employee from the database
	    public static void deleteEmployee(int id) {
	        String query = "DELETE FROM employees WHERE id = ?";
	        try (PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setInt(1, id);
	            int deletedRows = ps.executeUpdate();
	            if (deletedRows > 0) {
	                System.out.println("Employee deleted successfully!");
	            } else {
	                System.out.println("Employee not found.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Failed to delete employee: " + e.getMessage());
	        }
	    }

	    // View all Employees
	    public static void viewAllEmployees() {
	        String query = "SELECT * FROM employees";
	        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
	            while (rs.next()) {
	                Employee employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"),
	                         rs.getDouble("salary"));
	                System.out.println(employee);
	            }
	        } catch (SQLException e) {
	            System.out.println("Failed to retrieve employees: " + e.getMessage());
	        }
	    }

	    // Search Employee by Name
	    public static void searchEmployeeByName(String name) {
	        String query = "SELECT * FROM employees WHERE name LIKE ?";
	        try (PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setString(1, "%" + name + "%");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Employee employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"),
	                         rs.getDouble("salary"));
	                System.out.println(employee);
	            }
	        } catch (SQLException e) {
	            System.out.println("Failed to search employee: " + e.getMessage());
	        }
	    }

	    // Search Employee by Department
	    public static void searchEmployeeByDepartment(String department) {
	        String query = "SELECT * FROM employees WHERE department LIKE ?";
	        try (PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setString(1, "%" + department + "%");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Employee employee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"),
	                       rs.getDouble("salary"));
	                System.out.println(employee);
	            }
	        } catch (SQLException e) {
	            System.out.println("Failed to search employee: " + e.getMessage());
	        }
	    }
}
