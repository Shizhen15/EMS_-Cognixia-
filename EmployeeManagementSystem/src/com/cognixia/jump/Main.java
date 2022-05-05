package com.cognixia.jump;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.model.Employee;
import com.cognixia.jump.util.EmployeeManager;
import com.cognixia.jump.util.EmployeeManagerFile;
import com.cognixia.jump.util.EmployeeManagerInMemory;

// CRUD Operations - Create Read Update Delete

// Create an EMS that allows us to:
// 1. view all employees
// 2. view particular employee
// 3. create employees
// 4. delete employees
// 5. update employees
// 6. view all employees in a singular department (ex: all employees in HR)
// Expect: Console Based Menu

/*
 * Assignment:
 * - finish the EmployeeManagerInMemory (implement rest of methods)
 * - set up the create employee section of the menu
 * - send it over through slack (files, zip, or github)
 * */

public class Main {

	private static EmployeeManager manager;
	private static Scanner sc;

	public static void main(String[] args) {

		manager = new EmployeeManagerInMemory();
		// manager = new EmployeeManagerFile();

		sc = new Scanner(System.in);

		System.out.println("WELCOME TO THE EMPLOYEE MANAGEMENT SYSTEM (EMS)\n");

		mainMenu();

	}

	public static void mainMenu() {

		while (true) {

			try {
				System.out.println("\nPlease enter one of the following options :" + "\n1.) View Employees"
						+ "\n2.) Select Employee By Id" + "\n3.) Create Employee" + "\n4.) Update Employee"
						+ "\n5.) Delete Employee" + "\n6.) Exit");

				int option = sc.nextInt();
				sc.nextLine(); // getting rid of new line character

				switch (option) {
				case 1:
					viewEmployees();
					break;
				case 2:
					break;
				case 3:
					createEmployee();
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;

				default:
					System.out.println("\nPlease enter a number between 1 and 6");
					break;
				}

				if (option == 6) {
					System.out.println("\nThank you for using EMS. Good Bye!");
					break;
				}

			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("\nPlease enter a number between 1 and 6");
			}

		}

	}

	public static void viewEmployees() {

		while (true) {

			try {

				System.out.println("Select one of the follow:" + "\n1. Select all employees"
						+ "\n2. Select employees by department" + "\n3. Exit to return to main menu");

				int option = sc.nextInt();
				sc.nextLine();

				switch (option) {
				case 1:
					viewAllEmployees();
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					System.out.println("Enter number between 1 and 3");
					break;
				}

				if (option == 3) {
					break;
				}

			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("Enter number between 1 and 3");
			}
		}

	}

	public static void viewAllEmployees() {
		List<Employee> employees = manager.getAllEmployees();

		if (employees.isEmpty()) {
			System.out.println("No employees currently in EMS");
		} else {
			for (Employee e : employees) {
				System.out.println(e);
			}
		}
		System.out.println();
	}

	public static void createEmployee() {

		while (true) {
			try {
				System.out.println(
						"Please enter the new employee info in the order of name, dept, email, and salary (Hit enter)");

				String name = sc.nextLine();
				String dept = sc.nextLine();
				String email = sc.nextLine();
				int salary = sc.nextInt();

				int id = 0; // Placeholder

				Employee empl = new Employee(id, name, dept, salary, email);
				manager.createEmployee(empl);

				System.out.println("New employee registered");
				break;

			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("Incorrect input");
			}
		}

	}

}
