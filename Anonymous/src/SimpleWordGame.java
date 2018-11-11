import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SimpleWordGame {

	public Set<String> intersection(TreeSet<String> a, TreeSet<String> b) {
		TreeSet<String> results = a;
		results.retainAll(b);
		return results; 
	}

	public int points(String[] player, 
			String[] dictionary) {
		TreeSet <String> playerS =new TreeSet<> (Arrays.asList(player));
		TreeSet <String> dictionaryS = new TreeSet<> (Arrays.asList(dictionary));
		TreeSet<String> together = new TreeSet<> (intersection(playerS, dictionaryS));
		String [] togetherArray = together.toArray(new String[0]);
		int counter = 0;
		for(int s=0; s < togetherArray.length; s++) {
			String al = togetherArray[s];
			int b= al.length();
			counter += b * b ;
		}

		return counter;
	}

}
