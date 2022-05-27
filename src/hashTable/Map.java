package hashTable;

import java.util.ArrayList;
import java.util.Objects;

public class Map<K, V> {
	private ArrayList <HashNode <K, V> > bucketArray;
	private int numBuckets;
	private int size;
	
//	fuction for getting index of the given key
//	this function is not mention in the assignment but i created it to use in some other functions
	private int getBucketIndex(K key) {
		int hashCode = hashCode(key);
		int index = hashCode % numBuckets;
		index = index<0 ? index * -1 : index;
		return index;
	}
	
//	Cconstructor
	public Map() {
		bucketArray = new ArrayList<>();
		numBuckets = 10;
		size = 0;
		
		for(int i=0; i<numBuckets; i++) {
			bucketArray.add(null);
		}
	}
	
//	function for inserting a record in the hash table
	public void insert(K key, V value)
    {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode
                = new HashNode<K, V>(key, value, hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        if ((1.0 * size) / numBuckets >= 0.7) {
            ArrayList<HashNode<K, V> > temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    insert(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
     }
	
//	function for deleting the record for given key
	public V delete(K key) {
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);
		
		HashNode<K, V> head = bucketArray.get(bucketIndex);
		
		HashNode<K, V> prev = null;
		while(head != null) {
			if(head.key.equals(key) && hashCode == head.hashCode) {
				break;
			}
			prev = head;
			head = head.next;
		}
		
		if(head == null) {
			return null;
		}
		size--;
		if(prev != null) {
			prev.next = head.next;
		}
		else {
			bucketArray.set(bucketIndex, head.next);
		}
		
		V v = head.value;
		return v;
	}
	
//	function for getting the value of given key
	 public V getValueByKey(K key)
	    {
	        int bucketIndex = getBucketIndex(key);
	        int hashCode = hashCode(key);

	        HashNode<K, V> head = bucketArray.get(bucketIndex);

	        while (head != null) {
	            if (head.key.equals(key) && head.hashCode == hashCode)
	                return head.value;
	            head = head.next;
	        }

	        return null;
	    }
	
//	 Hash function
	public final int hashCode(K key) {
		return Objects.hash(key);
	}
	
//	size of hash table
	public int size() {
		return size;
	}
	
//	check is hash table is empty or not
	public boolean isEmpty() {
		return size() == 0;
	}
}
