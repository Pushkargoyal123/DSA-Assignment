package priorityQueue;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner scan = new Scanner(System.in);
	        System.out.println("Priority Queue Test\n");
	        System.out.println("Enter size of priority queue ");
	        PriorityQueue pq = new PriorityQueue(scan.nextInt());
	        char ch;
	        /* Perform Priority Queue operations */
	        do {
	            System.out.println("\nPriority Queue Operations\n");
	            System.out.println("1. insert");
	            System.out.println("2. remove");
	            System.out.println("3. check empty");
	            System.out.println("4. check full");
	            System.out.println("5. clear");
	            System.out.println("6. size");
	            System.out.println("7. Traverse");
	            System.out.println("8. Reverse");
	            int choice = scan.nextInt();
	            switch (choice) {
	                case 1:
	                    System.out.println("Enter value and priority");
	                    pq.enqueue(scan.nextInt(), scan.nextInt());
	                    break;
	                case 2:
	                	pq.dequeue();
	                    System.out.println("\nValue removed \n\n");
	                    break;
	                case 3:
	                    System.out.println("\nEmpty Status : " + pq.isEmpty());
	                    break;
	                case 4:
	                    System.out.println("\nFull Status : " + pq.isFull());
	                    break;
	                case 5:
	                    System.out.println("\nPriority Queue Cleared");
	                    pq.clear();
	                    break;
	                case 6:
	                    System.out.println("\nSize = " + pq.size());
	                    break;
	                case 7:
	                    pq.print();
	                    break;
	                case 8:
	                    pq.reverse();
	                    break;
	                default:
	                    System.out.println("Wrong Entry \n ");
	                    break;
	            }
	            System.out.println("\nDo you want to continue (Type y or n) \n");
	            ch = scan.next().charAt(0);
	        } while (ch == 'Y' || ch == 'y');
	}

}
