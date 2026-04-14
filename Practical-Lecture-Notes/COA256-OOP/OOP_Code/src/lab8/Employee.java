package lab8;

import java.time.LocalDate;

public class Employee {
	
	private final int EMPLOYEE_ID;
	private String name;
	private LocalDate dateOFContract;
	private int salary;
	
	public Employee(int employeeId, String name, LocalDate dateOFContract, int salary) {
		this.EMPLOYEE_ID = employeeId;
		this.name = name;
		this.dateOFContract = dateOFContract;
		this.salary = salary;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
