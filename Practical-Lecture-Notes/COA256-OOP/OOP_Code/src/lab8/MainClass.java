package lab8;

public class MainClass {
	
	//print the details of the employees in the array
	public static void printEmployees(Employee[] employees) {
		
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] employees = ReadWriteFunctions.readFile("employees.txt");
		printEmployees(employees);

	}

}
