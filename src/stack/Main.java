package stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack newStack = new Stack(10);
		newStack.push(10);
		newStack.push(20);
		newStack.push(11);
		newStack.push(24);
		System.out.println(newStack.peek());
		newStack.pop();
		System.out.println(newStack.contains(0));
		System.out.println(newStack.center());
		System.out.println(newStack.size());
		newStack.sort();
		newStack.print();
		newStack.reverse();
	}
}
