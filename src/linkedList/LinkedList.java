package linkedList;

public class LinkedList {
	
	private Node head;
	
	// function for inserting a node in the end of the list
	public LinkedList insert(LinkedList list, int data) {
		Node new_node = new Node(data);
		new_node.next = null;
		if(list.head == null) {
			list.head = new_node;
		}
		else {
			Node last = list.head;
			while(last.next != null) {
				last = last.next;
			}
			last.next = new_node;
		}
		return list;
	}
	
	// function for inserting node at particular position
	public LinkedList insertAtPosition(LinkedList list, int data, int index) {
		
		Node new_node = new Node(data);
		new_node.next = null;
		
		if(index < 0) {
			System.out.println("Invalid Index " + index);
			return list;
		}
		
		if(list.head == null) {
			if(index != 0) {
				return list;
			}
			else {
				list.head = new_node;
				return list;
			}
		}
		
		if(list.head != null && index == 0) {
			new_node.next = list.head;
			list.head = new_node;
			return list;
		}
		
		Node currentNode = list.head;
		Node prev = null;
		
		int i =0;
		
		while(i < index) {
			prev = currentNode;
			currentNode = currentNode.next;
			if(currentNode == null) {
				break;
			}
			i++;
		}
		
		new_node.next = currentNode;
		prev.next = new_node;
		return list;
	}
	
//	function for deleting a node if the given key found
	public LinkedList delete(LinkedList list, int key) {
		Node temp= list.head, prev = null;
		System.out.println();
		
		if(temp != null && temp.data == key) {
			System.out.println(key + " Element deleted");
			list.head = temp.next;
			return list;
		}
		
		while(temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		
		if(temp == null) {
			System.out.println("Element not found");
			return list;
		}
		
		prev.next = temp.next;
		System.out.println(key + " Element deleted");
		
		return list;
	}
	
//	function for deletinga node from an particular position
	public LinkedList deleteAtPosition(LinkedList list, int index) {
		System.out.println();
		
		Node currentNode = list.head, prev = null;
		
		if(index == 0 && currentNode.next != null) {
			list.head = currentNode.next;
			System.out.println(index + " position element deleted");
			return list;
		}
		
		int counter =0;
		while(currentNode != null) {
			if(counter == index) {
				prev.next = currentNode.next;
				System.out.println(index + " position element deleted");
				break;
			}
			else {
				prev = currentNode;
				currentNode = currentNode.next;
				counter++;
			}
		}
		
		if(currentNode == null) {
			System.out.println(index + " position element not found");
		}
		
		return list;
	}
	
//	function for getting the middle element of the list
	public int center(LinkedList list) {
		Node slow_ptr = list.head;
		Node fast_ptr = list.head;
		
		if(fast_ptr == null) {
			System.out.println("List is empty");
			return 0;
		}
		
		while(fast_ptr != null && fast_ptr.next != null) {
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
		}
		return slow_ptr.data;
	}
	
//	function for sort the list in increasing order
	public LinkedList sort(LinkedList list) {
		Node current = head, index = null;
		int temp;
		
		if(head == null) {
			System.out.println("List is Empty");
			return list;
		}
		
		else {
			while(current != null) {
				index = current.next;
				while(index != null) {
					if(current.data > index.data) {
						temp = current.data;
						current.data = index.data;
						index.data = temp;
					}
					index = index.next;
				}
				current = current.next;
			}
			return list;
		}
	}
	
//	function for reversing the list
	public LinkedList reverse(LinkedList list) {
		Node prev = null, current = list.head,next = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		list.head = prev;
		return list;
	}
	
//	function for get the size of the list
	public int size(LinkedList list) {
		Node temp = list.head;
		int count =0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
//	function for print the list
	public void print(LinkedList list) {
		Node currentNode = list.head;
		
		if(currentNode == null) {
			System.out.println("List is empty");
			return;
		}
		
		System.out.println("\nLinked List is : ");
		
		while(currentNode != null) {
			System.out.print(currentNode.data + "  ");
			currentNode = currentNode.next;
		}
	}
}
