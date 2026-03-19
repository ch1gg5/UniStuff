package lab7;


public class Volunteer extends StaffMember {
  private String availability;
  
  public Volunteer(String name, String availability) {
    super(name);
    this.availability = availability;
  }
  
  @Override
  public String toString() {
    return getName() + ", " + getTasks().toString() + ", " + availability;
  }
}
