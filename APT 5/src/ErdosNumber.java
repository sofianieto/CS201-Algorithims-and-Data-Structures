import java.util.*;

public class ErdosNumber {
	private Map<String, Set<String>> myGraph = new TreeMap<String,Set<String>>();
	private Map<String, Integer> myDistance = new TreeMap<String,Integer>();

	//This is the "main" method

	public String[] calculateNumbers(String[] pubs) {
		// TODO complete calculateNumbers
		myGraph = getAdjList(pubs);

		// for debugging your getAdjList
		//printMap(myGraph);

		// TODO initialize distances for every author
		for(String keys: myGraph.keySet()) {
			myDistance.put(keys, 0);
		}

		//  Traverse the graph starting at Erdos
		bfs("ERDOS");

		// TODO construct answer array
		TreeSet<String> ban = new TreeSet<String>();
		ban.addAll(myDistance.keySet());
		String[] ah = new String[ban.size()];
		int counter = 0;
		for(String keys: ban) {
			String adding = keys;
			if(keys.equals("ERDOS")) {
				adding = keys + " " + myDistance.get(keys);
			}

			if(myDistance.get(keys) != 0) {
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
			if(auths.length == 1 && !adjList.containsKey(auths[0]) ){
				adjList.put(auths[0], new TreeSet<String>());
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
		String[][] input = { { "ERDOS" }, { "NHSDLRTS DWJZSKZ NNQS CPCQ RROL", "ERDOS" },
				{ "KLEITMAN LANDER", "ERDOS KLEITMAN" }, { "ERDOS A", "A B", "B AA C" },
				{ "ERDOS B", "A B C", "B A E", "D F" },
				{ "ERDOS KLEITMAN", "CHUNG GODDARD KLEITMAN WAYNE", "WAYNE GODDARD KLEITMAN", "ALON KLEITMAN",
				"DEAN GODDARD WAYNE KLEITMAN STURTEVANT" },
				{ "A", "A B", "AA BA", "BA M", "M B", "B BA", "ERDOS BA" } };
		ErdosNumber e = new ErdosNumber();

		for (String[] in : input)
			System.out.printf("%s -> %s\n", Arrays.toString(in), Arrays.toString(e.calculateNumbers(in)));

	}

}
