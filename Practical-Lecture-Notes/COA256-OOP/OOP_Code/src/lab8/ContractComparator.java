package lab8;

public class ContractComparator implements java.util.Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		//compare date of contract of o1 and o2 and return 1 if o1 is before o2, 2 if o1 is after o2, and 0 if they are equal
		if (o1.getDateOFContract().isBefore(o2.getDateOFContract())) {
			return 1;
		} else if (o1.getDateOFContract().isAfter(o2.getDateOFContract())) {
			return 2;
		}
		
		return 0;
	}

}
