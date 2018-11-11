import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class UniqueNewYork {
	public int seen(String[] records) {
		ArrayList<String> bob = new ArrayList<String>();
		for(int i = 0; i< records.length; i++) {
			String[] plates = records[i].split(",");
			bob.addAll(Arrays.asList(plates));
		}
		TreeSet<String> theSet = new TreeSet<String>(bob);
		return theSet.size();
    }
}
