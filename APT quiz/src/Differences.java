import java.util.ArrayList;

import java.util.TreeMap;

public class Differences {
	public String[] matches(String[] a, String[] b) {
		TreeMap<String,Integer> aMap = new TreeMap<String,Integer>();
		TreeMap<String,Integer> bMap = new TreeMap<String,Integer>();
		
		for(String word: a) {
			if(! aMap.containsKey(word)) {
				aMap.put(word, 0);
			}
			aMap.put(word, aMap.get(word)+1);
			}
		
		for(String word: b) {
			if(! bMap.containsKey(word)) {
				bMap.put(word, 0);
			}
			bMap.put(word, bMap.get(word)+1);
			}
		
		ArrayList<String> answer = new ArrayList<String> ();
		for(String s : aMap.keySet()) {
			if(bMap.containsKey(s)) {
			int difference = aMap.get(s)- bMap.get(s);
			String base = s + " ==> ";
			//String append = String.join(", ", neat);
			answer.add(base+difference);
			}
			else {
				int difference = aMap.get(s);
				String base = s + " ==> ";
				//String append = String.join(", ", neat);
				answer.add(base+difference);
			}
			
		}
		return answer.toArray(new String[0]);
       
    }
}
