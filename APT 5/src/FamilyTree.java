import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class FamilyTree {
	private Map<String, Set<String>> myGraph = new TreeMap<String,Set<String>>();
	 public int firstBad(String[] data){
         // fill in code here
   }
		
	 private void addEdge(Map<String, Set<String>> adjList, String from, String to) {
			if (!adjList.containsKey(from)) {
				adjList.put(from, new TreeSet<String>());
			}
			adjList.get(from).add(to);

			if (!adjList.containsKey(to)) {
				adjList.put(to, new TreeSet<String>());
			}
			adjList.get(to).add(from);

		}
}
