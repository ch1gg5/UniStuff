package lab7;

import java.util.HashSet;

public abstract class StaffMember implements Taskable<Task> {
	
	private String name;
	private HashSet<Task> taskSet;
	
	public StaffMember(String name) {
		this.name = name;
		this.taskSet = new HashSet<Task>();
	}
	
	//Getter
	public String getName() {
		return name;
	}
	
	// Implenetation of Taskable interface methods
	@Override
	public void addTask(Task taskToBeAdded) {
		taskSet.add(taskToBeAdded);
	}
	
	@Override
	public void removeTask(Task taskToBeRemoved) {
		taskSet.remove(taskToBeRemoved);
	}
	
	@Override
	public HashSet<Task> getTasks() {
		return taskSet;
	}
	
	//overloading addTask method, but not overriding
	public void addTask(String taskToBeAdded) {
		taskSet.add(new Task(taskToBeAdded));
	}
	
	//overloading removeTask method, but not overriding
	public void removeTask(String taskToBeRemoved) {
		taskSet.remove(new Task(taskToBeRemoved));
	}
	
	// toString method must be overridden in all subclasses
	public abstract String toString();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
