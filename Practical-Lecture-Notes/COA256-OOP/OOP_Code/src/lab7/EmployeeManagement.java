package lab7; 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeManagement {
  public static void main(String[] args) {
    Employee emp1 = new Employee("Jordan",101, JobType.PERMANENT);
    Employee emp2 = new Employee("Taylor", 102, JobType.CONTRACT);
    Employee emp3 = new Employee("Casey", 103, JobType.TEMPORARY);
    Employee emp4 = new Employee("Riley", 104, JobType.TEMPORARY);
    Volunteer vol1 = new Volunteer("Chris", "Mondays");
    Volunteer vol2 = new Volunteer("Alex", "Weekends only");

    List<StaffMember> smList = new ArrayList<>();
    smList.add(emp1);
    smList.add(emp2);
    smList.add(emp3);
    smList.add(emp4);
    smList.add(vol1);
    smList.add(vol2);

    for (StaffMember sm : smList) {
      System.out.println(sm.getName());
    }

    // part c)    
    HashMap<Integer, Employee> empHashMap = new HashMap<>();

    for (StaffMember sm : smList) {
      if (sm instanceof Employee) {
        Employee emp = (Employee) sm;
        empHashMap.put(emp.getEmployeeID(),emp);
      }
    }


    //System.out.println("Casey is retiring, we wish the best of luck in future endeavours!");
    empHashMap.remove(103);

    System.out.println(empHashMap.containsKey(103));


    //Updating employee's 104 details.
    if(empHashMap.containsKey(104)) {
      empHashMap.get(104).addTask("contact customers");
      empHashMap.get(104).addTask("ConTacT CustOmers");
      empHashMap.get(104).addTask("prepare some documents");
      empHashMap.get(104).setEmployeeJobType(JobType.PERMANENT);
    }

    for(HashMap.Entry<Integer, Employee> entry : empHashMap.entrySet()){
      System.out.println(entry.getValue().toString()); 
    }

    writeIntoFile(empHashMap,"output.txt");
  }  

  public static void writeIntoFile(Map<Integer, Employee> data, String fileName) {
    BufferedWriter bw = null;
    try {
      bw = new BufferedWriter(new FileWriter(fileName,false)); 
      // false here means that we don't want to append data to the content of the file. 
      // If we need to append, then we should use true.
      // When we don't pass the second parameter (false/true), by default it would be false.
      for(HashMap.Entry<Integer, Employee> entry : data.entrySet()){
        bw.write(entry.getValue().toString() + "\n");
      }

    } catch(IOException e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
    finally {
      try {
        if(bw != null) {
          bw.close();
        }
      } catch(IOException e) {
        System.err.println(e.getMessage());
        e.printStackTrace();
      }
    }
  }
}
