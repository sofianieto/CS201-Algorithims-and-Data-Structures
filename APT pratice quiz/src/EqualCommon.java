import java.util.ArrayList;
import java.util.TreeMap;


public class EqualCommon {
	public String[] matches(String[] a1, String[] a2) {
		TreeMap<String,Integer> a1Map = new TreeMap<String,Integer>();
		TreeMap<String,Integer> a2Map = new TreeMap<String,Integer>();
		//making a1 map
		for(String word: a1) {
			if (! a1Map.containsKey(word)){
				a1Map.put(word, 1);
			}
			if (a1Map.containsKey(word)) {
				a1Map.put(word, a1Map.get(word) + 1);
			}
		}
		//making a2 map
		for(String word: a1) {
			if (! a2Map.containsKey(word))m{
				a2Map.put(word, 1);
			}
			if (a1Map.containsKey(word)) {
				a1Map.put(word, a1Map.get(word) + 1);
			}
		}
		
		ArrayList<String> mary = new ArrayList<String>();
			/*for(String s: a1Map.keySet()) {
				if(a2Map.containsKey(s) && a1Map.get(s).equals(a2Map.get(s))) {
					mary.add(s);
				}
			}  */
		//mary.addAll(a2Map.keySet());
			String [] theLast = mary.toArray(new String[mary.size()]);
				}
	

public static void main (String[]args) {
	EqualCommon myAnon = new EqualCommon();
	String[] a1 = new String[] {"a","a","c","c","b","b"};
	String[] a2 = new String[] {"a","a","b","b","c","d","d"};
	
	myAnon.matches(a1,a2);
}

}

