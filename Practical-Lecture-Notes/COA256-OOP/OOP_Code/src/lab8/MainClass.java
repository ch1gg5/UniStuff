package lab8;

public class MainClass {
	
	//print the details of the employees in the array
	public static void printEmployeesById(Employee[] employees) {
		
		//compare the id numbers of the employees and print them in ascending order of their id numbers
		//use a temp variable to store the employee while swapping
		
		Employee temp;
		
		for(int i = 0; i < employees.length; i++) {
			for(int j = 0; j < employees.length - 1; j++) {
				if(employees[j].getEmployeeId() > employees[j+1].getEmployeeId()) {
					temp = employees[j];
					employees[j] = employees[j+1];
					employees[j+1] = temp;
				}
			}
		}
		
		for(Employee emp : employees) {
			
			System.out.println("Employee ID: " + emp.getEmployeeId());
			System.out.println("Name: " + emp.getName());
			System.out.println("Date of Contract: " + emp.getDateOFContract());
			System.out.println("Salary: " + emp.getSalary());
			System.out.println();
			
		}	
		
	}
	
	//print the details of the employees in the array by contract date in ascending order
	public static void printEmployeesByContractDate(Employee[] employees) {
		//compare the contract date of the employees and print them in ascending order of their contract date
		//use a temp variable to store the employee while swapping
		//use the ContractComparator class to compare the contract date of the employees
		// if the comparator returns 1, then the first employee is before the second employee and they are in the correct order, so do nothing
		
		Employee temp;
		ContractComparator contractComparator = new ContractComparator();
		for(int i = 0; i < employees.length; i++) {
			for(int j = 0; j < employees.length - 1; j++) {
				if(contractComparator.compare(employees[j], employees[j+1]) == 2) {
					temp = employees[j];
					employees[j] = employees[j+1];
					employees[j+1] = temp;
				}
			}
		}
		
		for(Employee emp : employees) {
			
			System.out.println("Employee ID: " + emp.getEmployeeId());
			System.out.println("Name: " + emp.getName());
			System.out.println("Date of Contract: " + emp.getDateOFContract());
			System.out.println("Salary: " + emp.getSalary());
			System.out.println();
			
		}
		
		
	}
	
	//print the details of the employees in the array by salary in decending order using SalaryComparator
	public static void printEmployeesBySalary(Employee[] employees) {
		//compare the salary of the employees and print them in descending order of their salary
		//use a temp variable to store the employee while swapping
		//use the SalaryComparator class to compare the salary of the employees
		// if the comparator returns 2, then the first employee is greater than the second employee and they are in the correct order, so do nothing
		
		Employee temp;
		SalaryComparator salaryComparator = new SalaryComparator();
		for(int i = 0; i < employees.length; i++) {
			for(int j = 0; j < employees.length - 1; j++) {
				if(salaryComparator.compare(employees[j], employees[j+1]) == 2) {
					temp = employees[j];
					employees[j] = employees[j+1];
					employees[j+1] = temp;
				}
			}
		}
		
		for(Employee emp : employees) {
			
			System.out.println("Employee ID: " + emp.getEmployeeId());
			System.out.println("Name: " + emp.getName());
			System.out.println("Date of Contract: " + emp.getDateOFContract());
			System.out.println("Salary: " + emp.getSalary());
			System.out.println();
			
		}
		
	}
	
	
	public static void add2000ToLowSalaryEmployees(Employee[] employees, int maxSalary) {
		//add 2000 to the salary of employees whose salary is less than or equal to the maxSalary
		
		for(Employee emp : employees) {
			if(emp.getSalary() <= maxSalary) {
				emp.setSalary(emp.getSalary() + 2000);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] employees = ReadWriteFunctions.readFile("employees.txt");
		//printEmployeesById(employees);
		//add2000ToLowSalaryEmployees(employees, 30000);
		//ReadWriteFunctions.writeIntoFile(employees, "Employees_updated.txt");
		//printEmployeesByContractDate(employees);
		printEmployeesBySalary(employees);

	}

}
