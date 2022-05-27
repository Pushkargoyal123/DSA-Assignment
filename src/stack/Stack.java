package stack;

public class Stack {
	private int arr[];
	private int top;
	private int capacity;
	
//	Stack parameterized constructor for size
	Stack(int size){
		arr = new int[size];
		capacity = size;
		top = -1;
	}
	
//	stack push method
	public void push(int x) {
		if(isFull()) {
			System.out.println("Stack Overflow \nProgram Terminated\n");
			return;
		}
		System.out.println("Inserting " + x);
		arr[++top] = x;
	}
	
//	stack pop method
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack Underflow\nProgram Terminated\n");
			return -1;
		}
		System.out.println("Removing " + peek());
		return arr[top--];
	}
	
//	peek method for getting the top element
	public int peek() {
		if(!isEmpty()) {
			return arr[top];
		}
		else {
			return -1;
		}
	}
	
//	function for fetching the size of the Stack
	public int size() {
		return top+1;
	}
	
//	this function check the stack is empty or not
	public boolean isEmpty() {
		return top == -1;
	}
	
//	this function check the stack is full or not
	public boolean isFull() {
		return top == (capacity -1);
	}
	
//	this function checks that the provided value is present in the stack or not
	public boolean contains(int value) {
		boolean bool = false;
		for(int i=0; i< size(); i++) {
			if(arr[i] == value ) {
				bool = true;
				break;
			}
		}
		return bool;
	}
	
//	function for getting middle element of the stack
	public int center() {
		if(size() == 0) {
			System.out.println("Stack is Empty");
			return -1;
		}
		return arr[size() / 2];
	}
	
//	function for sort the stack in increasing order
	public void sort() {
		if(top == -1) {
			System.out.println("Stack is Empty");
			return;
		}
		for(int i=0; i<= top; i++) {
			for(int j=i+1; j<=top; j++) {
				if(arr[i] > arr[j]) {
					int temp;
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		System.out.println();
		for(int i=0; i<=top; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
//	function for reverse the elements of stack
	public void reverse() {
		if(top == -1) {
			System.out.println("Stack is empty");
			return;
		}
		System.out.println();
		for(int i=top; i>=0; i--) {
			System.out.print(arr[i] + " ");
		}
	}
	
//	function for print the elements of stack
	public void print() {
		if(top == -1) {
			System.out.println("Stack is Empty");
			return;
		}
		System.out.println();
		for(int i=0; i<= top; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
