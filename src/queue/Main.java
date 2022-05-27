package queue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue que = new Queue(10);
		que.enqueue(10);
		que.enqueue(30);
		que.enqueue(20);
		que.enqueue(40);
		que.enqueue(50);
		que.enqueue(35);
		que.dequeue();
		System.out.println(que.peek());
		System.out.println(que.size());
		System.out.println(que.center());
		System.out.println(que.contains(20));
		que.print();
		que.sort();
		que.print();
		que.reverse();
		que.print();
	}

}
