package priorityQueue;

public class PriorityQueue {
	private Item arr[];
	private int capacity;
	private int size;
	
//	constructor for creating queue
	PriorityQueue(int size){
		arr = new Item[size];
		capacity = size;
		for(int i=0; i<size; i++) {
			arr[i] = new Item();
		}
		this.size = -1;
	}
	
	 public void clear() {
	        arr = new Item[capacity];
	        size = -1;
	    }
	
//	function for inserting an item in a queue from reer end
	public void enqueue(int value, int priority) {
		if(isFull()) {
			System.out.println("Queue Overflow\nProgram Terminated\n");
			return ;
		}
		size++; 
		arr[size].setValue(value);
		arr[size].setPriority(priority);
	}

//	function for deleting an item at front end
	public void dequeue() {
		if(isEmpty()) {
			System.out.println("Queue Underflow\nProgram Terminated\n");
			return;
		}
		for(int i=peek(); i<size; i++) {
			arr[i] = arr[i+1];
		}
	}
	
//	function for getting front value
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue Underflow\nProgram Terminated");
			return -1;
		}
		
		int highestPriority = Integer.MIN_VALUE;
		int ind = -1;
		for(int i=0; i<=size; i++) {
			if(highestPriority == arr[i].getPriority() && ind > -1 && arr[ind].getValue() < arr[i].getValue()) {
				highestPriority = arr[i].getPriority();
				ind = i;
			}
			else if(highestPriority < arr[i].getPriority()) {
				highestPriority = arr[i].getPriority();
				ind = i;
			}
		}
		return arr[ind].getValue();
	}
	
//	function for getting size of queue
	public int size() {
		return size + 1;
	}
	
////	function for fetching middle element from a queue
	public int center() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		return arr[size/2].getValue();
	}
////	function for sort the queue in increasing order
	
////	function for reversing the queue
	public void reverse() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println();
		for(int i=size - 1; i>0; i--) {
			System.out.print(arr[i].getValue() + " ");
		}
		System.out.println();
	}
	
//	function for checking queue is empty or not
	public boolean isEmpty() {
		return (size == 0);
	}
	
//	function for checking que is full or not
	public boolean isFull() {
		return size == capacity;
	}
	
//	function for printing the queue elements
	public void print() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println();
		for(int i=0; i<=size; i++) {
			System.out.print(arr[i].getValue() + " ");
		}
		System.out.println();
	}
}

