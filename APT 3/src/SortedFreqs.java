import java.util.TreeMap;

public class SortedFreqs {
	public int[] freqs(String[] data) {
		TreeMap<String,Integer> bob = new TreeMap<String,Integer>();

		for(String s:data) {
			if(! bob.containsKey(s)) {
				bob.put(s, 1);
			}
			else{
				bob.put(s, bob.get(s)+1);
			}
		}

		int[] order = new int[bob.size()];
		int counter = 0; 
		for(String s: bob.keySet()) {
			order[counter] = bob.get(s);
			counter++;
		}
		
		return order;

	}
}

