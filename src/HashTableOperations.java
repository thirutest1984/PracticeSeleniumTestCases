import java.util.Hashtable;

public class HashTableOperations {

	public static void main(String[] args) {

		Hashtable<String, Integer> ht = new Hashtable<>();
		ht.put("Hello", 1);
		ht.put("World", 2);
		ht.put("Good", 3);
		
		System.out.println(ht.get("Good"));
	}

}
