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
	
	//getters and setters
	public int getEmployeeId() {
		return EMPLOYEE_ID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getDateOFContract() {
		return dateOFContract;
	}
	
	public void setDateOFContract(LocalDate dateOFContract) {
		this.dateOFContract = dateOFContract;
	}
	
	//set date being passed as a string in the format of "DD-MM-YYYY"
	public void setDateOFContract(String date) {
		String[] dateParts = date.split("-");
		int day = Integer.parseInt(dateParts[0].trim());
		int month = Integer.parseInt(dateParts[1]);
		int year = Integer.parseInt(dateParts[2]);
		this.dateOFContract = LocalDate.of(year, month, day);
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
