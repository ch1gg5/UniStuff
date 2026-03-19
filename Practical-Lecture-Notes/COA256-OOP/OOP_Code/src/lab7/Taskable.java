package lab7;




import java.util.Collection;

/**
 * The {@code Taskable} interface defines a contract for entities that are capable of
 * receiving, managing, and removing tasks. Any class implementing this interface
 * is expected to be able to add, remove, and retrieve tasks.
 * 
 * <p>This interface ensures that all taskable entities can manage tasks of type {@code T},
 * where {@code T} extends the {@link Task} class.</p>
 * 
 * @param <T> the type of task that this interface handles, which must extend {@link Task}
 * @see Task
 * @author Team Robot
 */
public interface Taskable <T extends Task> {
  /**
   * any taskable entity must provide the possibility to be assigned a task. 
   * @param taskToBeAdded is a task to be added
   */
  void addTask(T taskToBeAdded);
  
  /**
   * Removes a specific task from the taskable entity.
   * This method provides the ability to remove an already assigned task.
   * 
   * @param taskToBeRemoved the task to be removed from the entity, cannot be null
   */
  void removeTask(T taskToBeRemoved);
  
  /**
   * Retrieves all tasks assigned to this taskable entity.
   * 
   * @return a {@link Collection} containing all the tasks currently assigned to the entity,
   *         never null, but potentially empty
   */
  Collection<T> getTasks();

}
