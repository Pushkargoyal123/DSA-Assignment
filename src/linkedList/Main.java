package linkedList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.insert(list, 10);
		list.insert(list, 20);
		list.print(list);
		list.deleteAtPosition(list, 6);
		list.print(list);
		list.delete(list, 10);
		list.sort(list);
		list.print(list);
		list = list.reverse(list);
		list.print(list);
		System.out.println(list.size(list));
		System.out.println(list.center(list));
		
	}

}
