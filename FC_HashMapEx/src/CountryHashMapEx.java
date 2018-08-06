import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountryHashMapEx {
	
	public static void main(String[] args) {
		
		Map<Integer,String> hashMap=new HashMap<Integer,String>();
		hashMap.put(3, "Spain");
		hashMap.put(2, "France");
		hashMap.put(5, "Germany");
		hashMap.put(8, "England");
		
		for (Integer c : hashMap.keySet()) { 
			System.out.println("The country at key " + c + " is " + hashMap.get(c)); 
		}

		
		Map<String, String> map=new HashMap<String,String>();
		map.put("cat", "burmese");
		map.put("dog", "spaniel");
		map.put("horse", "pinto");
		map.put("chicken", "bantam");
		
		System.out.println("List");
		for(String a: map.keySet()) {
			System.out.println("The animal "+a+" is a "+map.get(a));
		}
		System.out.println("-----");
//		TreeMap<String,String> sortedMap=new TreeMap<String,String>(map);
//		for(String a: sortedMap.keySet()) {
//			System.out.println("The animal "+a+" is a "+sortedMap.get(a));
//		}
		System.out.println(map.containsValue("burmese"));
		map.remove("cat");
		
		System.out.println("List");
		for(String a: map.keySet()) {
			System.out.println("The animal "+a+" is a "+map.get(a));
		}
		System.out.println("-----");
		
		System.out.println(map.containsValue("burmese"));
	}
	
	
}
