package lab7;



/**
 * The {@code Task} class represents a task with a description. 
 * This class provides a way to encapsulate a task description, ensuring that the description is 
 * non-null, does not consist only of whitespace, and is properly formatted (with the first letter capitalized).
 * 
 * <p>Tasks are immutable once created, meaning their descriptions cannot be changed after instantiation.</p>
 * 
 * <p>The class includes:</p>
 * <ul>
 *   <li>Validation of the task description during creation.</li>
 *   <li>A method to retrieve the description.</li>
 *   <li>An override of {@link Object#equals(Object)} to compare tasks based on their description.</li>
 *   <li>An override of {@link Object#hashCode()} to ensure consistent hashing with equals.</li>
 *   <li>A method to return the task's description as a string.</li>
 * </ul>
 * 
 * <p>This class enforces that the task description cannot be null or consist solely of whitespace characters. The description is stored in a standardized format, where the first letter is capitalized, and the rest are in lowercase.</p>
 * 
 * <p><b>Note:</b> When overriding {@link Object#equals(Object)}, it is important to also override {@link Object#hashCode()} to maintain consistency between the two methods, as required by the contract of {@link Object#equals(Object)}.</p>
 * 
 * @see Object#equals(Object)
 * @see Object#hashCode()
 */
public class Task {
  // Description that cannot be changed after creation
  private final String description;

  /**
   * Creates a task with the given description. 
   * This constructor validates the provided description, ensuring it is non-null,
   * does not consist solely of whitespace, and formats it by capitalizing the first letter.
   * 
   * @param description the description of the task, must be a non-null and non-whitespace String.
   * @throws NullPointerException if the provided description is null.
   * @throws IllegalArgumentException if the provided description consists only of whitespace characters.
   */
  public Task(String description) throws NullPointerException, IllegalArgumentException {
    if (null == description) {
      throw new NullPointerException("Description cannot be null or empty");
    }
    if (description.trim().isEmpty()) {
      throw new IllegalArgumentException("Description cannot consist "
                                    + "only of whitespace characters)");
    }
 // Format description: trim, convert to lowercase, capitalize first letter
    String res = description.trim().toLowerCase();
    res = res.substring(0,1).toUpperCase() + res.substring(1);
    //Description is stored in lower case.
    this.description = res;
  }

  /**
   * Returns the description of the task.
   * 
   * @return the description of the task.
   */
  public String getDescription() {
    return description;
  }
  
  /**
   * Compares this task to the specified object. Two Task objects are considered equal
   * if and only if their String descriptions are equal.
   * 
   * @param obj the object to be compared with this task.
   * @return {@code true} if this task is equal to the specified object, otherwise {@code false}.
   */
  @Override
  public boolean equals(Object obj) {
    //Check if obj is a reference to this object, return true.
    if (this == obj)
      return true;
    //If obj is not referring to any Object, return false.
    if (obj == null) 
      return false;
    // If the runtime classes are not the same, return false.
    if (getClass() != obj.getClass())
      return false;
    // obj is an instance of Task so we can downcast without errors.
    Task other = (Task) obj;
    // Return true if and only if the String descriptions of the tasks are the same.
    return this.description.equals(other.description);
  }
  
  /**
   * Returns a hash code value for the task. The hash code is computed based on the description.
   * 
   * @return a hash code value for this task.
   * @see #equals(Object)
   * @see Object#hashCode()
   */
  @Override
  public int hashCode() {
    return description.hashCode();
  }
  
  /**
   * Returns a string representation of the task. The string is simply the task's description.
   * 
   * @return the description of the task as a string
   */
  @Override
  public String toString() {
    return description;
  }

}
