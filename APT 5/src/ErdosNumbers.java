import java.util.*;

public class ErdosNumbers {
	private Map<String, Set<String>> myGraph;
	private Map<String, Integer> myDistance;

	//This is the "main" method
	
	public String[] calculateNumbers(String[] pubs) {
		// TODO complete calculateNumbers
		myGraph = getAdjList(pubs);
		
		// for debugging your getAdjList
		printMap(myGraph);
	
		// TODO initialize distances for every author
		for(String keys: myGraph.keySet()) {
			if(keys == "ERDOS") {
				myDistance.put(keys, 0);
			} 
			myDistance.put(keys, -1);
		}
		/**for(String keys: myDistance.keySet()) {
			System.out.println(keys + myDistance.get(keys));
		} **/
		//  Traverse the graph starting at Erdos
		bfs("ERDOS");

		// TODO construct answer array
		TreeSet<String> ban = new TreeSet<String>();
		ban.addAll(myGraph.keySet());
		String[] ah = new String[ban.size()];
		int counter = 0;
		for(String keys: ban) {
			String adding = keys;
			if(myDistance.get(keys) != -1) {
				adding = keys + " " + myDistance.get(keys);
			}
			ah[counter] = adding;
			counter++;
		}
		return ah;

	}

	public static void printMap(Map<?, ?> map) {
		System.out.print("{");
		for (Map.Entry<?, ?> e : map.entrySet())
			System.out.printf("%s: %s, ", e.getKey().toString(), e.getValue().toString());
		System.out.println("}");
	}

	/**
	 * Adds birectional edges from->to and to->from to the adjacency list represented by adjList
	 */
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

	public Map<String, Set<String>> getAdjList(String[] pubs) {
		Map<String, Set<String>> adjList = new TreeMap<String, Set<String>>();
		
		for(String p:pubs) {
			String[] auths = p.split("\\s+");
			for(int i = 0; i < auths.length; i++) {
				for(int j= i+1; j< auths.length; j++)
					addEdge(adjList, auths[i], auths[j]); // this is okay cause your addEdge method adds them both ways
			}
		}
		// TODO complete adjList
		return adjList;
	}

	public Set<String> bfs(String start) {

		Set<String> visited = new TreeSet<String>();
		Queue<String> qu = new LinkedList<String>();
		visited.add(start);
		qu.add(start);

		while (qu.size() > 0) {
			String v = qu.remove();
			// Note: checks to make sure vertex is in graph
			if (myGraph.containsKey(v))
				for (String adj : myGraph.get(v)) {
					if (!visited.contains(adj)) { //cause if visited it is already in closer proximity to erdos
						visited.add(adj);
						myDistance.put(adj, myDistance.get(v) + 1); // you get v's number and add 1
						qu.add(adj);
					}
				}
		}
		return visited;
	}

	public static void main(String[] args) {
		String[][] input = {  { "NHSDLRTS DWJZSKZ NNQS CPCQ RROL", "ERDOS" } };
		ErdosNumbers e = new ErdosNumbers();

		for (String[] in : input)
			System.out.printf("%s -> %s\n", Arrays.toString(in), Arrays.toString(e.calculateNumbers(in)));

	}

}
