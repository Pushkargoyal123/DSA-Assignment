package hashTable;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new Map<>();
        Scanner s = new Scanner(System.in);
        int choice = 0;
        while(choice != 6)
        {
            System.out.println("Hash Table");
            System.out.println("1. Insert");
            System.out.println("2. Remove");
            System.out.println("3. Size");
            System.out.println("4. Check if hash table is empty");
            System.out.println("5. Get the value by key");
            System.out.println("6. exit\n");
            choice = s.nextInt();
            switch(choice)
            {
                case 1: System.out.println("Enter the value string");
                    String value = s.next();
                    System.out.println("\nEnter the key for "+value
                            +" (please make sure you don't repeat any previously used key)");
                    int key = s.nextInt();
                    map.insert(value, key);
                    break;
                case 2: System.out.println(map.delete("this"));
                    break;
                case 3: System.out.println("The size of the table is "+map.size());
                    break;
                case 4: System.out.println(map.isEmpty());
                    break;
                case 5: 
                	System.out.println("Enter the Key : ");
                	String getKey = s.next();
                	if(map.getValueByKey(getKey) != null) {
                		System.out.println("Key does not exist\n");
                	}
                	else {
                		System.out.println("Value of " + getKey + " is : " + map.getValueByKey(getKey) != null);
                	}
                	break;
                case 6: System.out.println("Thank You !!! \n");
                	break;
                default: System.out.println("Enter a valid choice");
            }
        }
	}

}
