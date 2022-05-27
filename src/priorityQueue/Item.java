package priorityQueue;

public class Item {
	private int value;
	private int priority;
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public String toString() {
        return "Item : " + value + "\nPriority : " + priority;
    }
}
