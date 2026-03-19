package lab7;


public class Employee extends StaffMember {
	private final int employeeID;
	private JobType employeeJobType;
	
	public Employee(String name, int employeeID, JobType employeeJobType) {
		super(name);
		this.employeeID = employeeID;
		this.employeeJobType = employeeJobType;
	}
	
	//Overloading constructor to allow string instead of job type
	public Employee(String name, int employeeID, String employeeJobType) {
		this(name, employeeID, JobType.valueOf(employeeJobType));
	}
	
	//Getters
	public int getEmployeeID() {
		return employeeID;
	}
	
	public JobType getEmployeeJobType() {
		return employeeJobType;
	}
	
	//setter for job type
	public void setEmployeeJobType(JobType employeeJobType) {
		this.employeeJobType = employeeJobType;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Employee [Name: " + getName() + ", ID: " + employeeID
				+ ", Job Type: " + employeeJobType + "]";
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stu

	}

}
