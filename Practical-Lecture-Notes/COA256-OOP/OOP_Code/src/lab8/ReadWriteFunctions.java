package lab8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

final class ReadWriteFunctions {
	
	
	public static Employee[] readFile(String fileName) {
		//read file and create an array of employees
		//read the file the find the size first and then create the array and read the file again to fill the array
		BufferedReader br = null;
		int size = 0;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line;
			
			while((line = br.readLine()) != null) {
				size++;
			}
			br.close();
			
			Employee[] employees = new Employee[size];
			br = new BufferedReader(new FileReader(fileName));
			int index = 0;
			
			while((line = br.readLine()) != null) {
				String[] data = line.split(",");
				int employeeId = Integer.parseInt(data[0]);
				String name = data[1];
				
				String[] dateParts = (data[2].split("-"));
				int day = Integer.parseInt(dateParts[0].trim());
				int month = Integer.parseInt(dateParts[1]);
				int year = Integer.parseInt(dateParts[2]);
				LocalDate dateOfContract = LocalDate.of(year, month, day);
				
				int salary = Integer.parseInt(data[3].trim());
				employees[index] = new Employee(employeeId, name, dateOfContract, salary);
				index++;
			}
			
			br.close();
			return employees;
			
			
		} catch(IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void writeIntoFile(Employee[] employees, String fileName) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(fileName,false)); 
			// false here means that we don't want to append data to the content of the file. 
			// If we need to append, then we should use true.
			// When we don't pass the second parameter (false/true), by default it would be false.
			for(Employee emp : employees){
				bw.write(emp.getEmployeeId() + ", " + emp.getName() + ", " + emp.getDateOFContract() + ", " + emp.getSalary() + "\n");
			}
			
			bw.close();
			
		} catch(IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
