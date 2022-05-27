package queue;

import java.util.Arrays;

public class Queue {
	private int[] arr;
	private int front;
	private int rear;
	private int capacity;
	private int count;
	
//	constructor for creating queue
	Queue(int size){
		arr = new int[size];
		capacity = size;
		front = 0;
		rear = -1;
		count = 0;
	}
	
//	function for inserting an item in a queue from reer end
	public void enqueue(int item) {
		if(isFull()) {
			System.out.println("Queue Overflow\nProgram Terminated\n");
			return ;
		}
		rear = (rear + 1) % capacity;
		arr[rear] = item;
		count++;
	}

//	function for deleting an item at front end
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue Underflow\nProgram Terminated\n");
			return -1;
		}
		int x = arr[front];
		front = (front + 1) % capacity;
		count--;
		return x;
	}
	
//	function for getting front value
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue Underflow\nProgram Terminated");
			return -1;
		}
		return arr[front];
	}
	
//	function for checking is the item is present in the queue or not
	public boolean contains(int item) {
		boolean bool = false;
		if(count == 0) {
			System.out.println("queue is empty");
			return false;
		}
		if(rear >= front) {
			for(int i=front; i<=rear; i++) {
				if(arr[i] == item) {
					bool = true;
					break;
				}
			}
		}
		else {
			for(int i=front; i<size(); i++) {
				if(arr[i] == item) {
					bool = true;
					break;
				}
			}
			for(int i=0; i<=rear; i++) {
				if(arr[i] == item) {
					bool = true;
					break;
				}
			}
		}
		return bool;
	}
	
//	function for getting size of queue
	public int size() {
		return count;
	}
	
//	function for fetching middle element from a queue
	public int center() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		int i, loopCount = 0;
		for(i=front; i!=rear && loopCount < size()/2; i=(i+1) % size()) {
			loopCount++;
		}
		return arr[i];
	}
	
//	function for sort the queue in increasing order
	public void sort() {
		Queue temp = new Queue(size());
		while(!isEmpty()) {
			temp.enqueue(peek());
			dequeue();
		}
		rear = -1;
		front =0;
		Arrays.sort(temp.arr);
		for(int i=0; i<temp.size(); i++) {
			enqueue(temp.arr[i]);
		}
	}
	
//	function for reversing the queue
	public void reverse() {
		Queue temp = new Queue(size());
		while(!isEmpty()) {
			temp.enqueue(peek());
			dequeue();
		}
		rear = 0;
		front =1;
		for(int i=temp.size() - 1; i>=0; i--) {
			enqueue(temp.arr[i]);
		}
	}
	
//	function for checking queue is empty or not
	public boolean isEmpty() {
		return (count == 0);
	}
	
//	function for checking que is full or not
	public boolean isFull() {
		return count == capacity;
	}
	
//	function for printing the queue elements
	public void print() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println();
		if(rear >= front) {
			for(int i=front; i<=rear; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		else {
			for(int i=front; i<size(); i++) {
				System.out.print(arr[i] + " ");
			}
			for(int i=0; i<=rear; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
}
