package lab8;

public class SalaryComparator implements java.util.Comparator<Employee> {


	@Override
	public int compare(Employee o1, Employee o2) {
		//compare salary of o1 and o2 and return 2 if o1 is less than o2, 1 if o1 is greater than o2, and 0 if they are equal
		if (o1.getSalary() < o2.getSalary()) {
			return 2;
		} else if (o1.getSalary() > o2.getSalary()) {
			return 1;
		}
		
		return 0;
	}

}
