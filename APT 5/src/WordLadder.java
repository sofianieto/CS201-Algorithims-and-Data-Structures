import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordLadder {
	private Map<String, Set<String>> myGraph = new TreeMap<String,Set<String>>();


	public String ladderExists(String[] words, 
			String from, String to) {

		//makeBarn
		ArrayList<String> barn = new ArrayList<String>();
		for(String a : words) {
			barn.add(a);
		}

		//add to and from
		for(int i = 0; i< barn.size(); i++) {
			String s = barn.get(i);
			String k = from;
			char [] sChar = s.toCharArray();
			char [] kChar = k.toCharArray();
			int decider = 0; 
			for(int m=0; m < sChar.length; m++) {
				if(sChar[m] == kChar[m])
					decider++;
			}

			if(decider + 1 == sChar.length)
				addEdge(myGraph,s,k);
			else
				continue;
		}

		for(int i = 0; i< barn.size(); i++) {
			String s = barn.get(i);
			String k = to;
			char [] sChar = s.toCharArray();
			char [] kChar = k.toCharArray();
			int decider = 0; 
			for(int m=0; m < sChar.length; m++) {
				if(sChar[m] == kChar[m])
					decider++;
			}

			if(decider + 1 == sChar.length)
				addEdge(myGraph,s,k);
			else 
				continue;
		}

		if(!(myGraph.containsKey(from)) || !(myGraph.containsKey(to))){
			return "none";
		}

		//make adjacency list
		for(int i = 0; i< barn.size(); i++ ) {
			for(int j = i+1; j< barn.size(); j++) {
				String s = barn.get(i);
				String k = barn.get(j);
				char [] sChar = s.toCharArray();
				char [] kChar = k.toCharArray();
				int decider = 0; 
				for(int m=0; m < sChar.length; m++) {
					if(sChar[m] == kChar[m])
						decider++;
				}

				if(decider + 1 == sChar.length)
					addEdge(myGraph,s,k);
				else 
					continue;
			}
		}

		//check if it matches 
		boolean ah = bfs(from,to);

		if(ah == true) {
			return "ladder";
		}
		if(ah == false) {
			return "none";
		}
		return "";

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

	public boolean bfs(String from, String to) {
		Set<String> visited = new TreeSet<String>();
		visited.add(from);

		Queue<String> qu = new LinkedList<String>();

		qu.add(from);

		while (qu.size() > 0) {
			String v = qu.remove();
			// Note: checks to make sure vertex is in graph
			if (myGraph.containsKey(v)) {
				for (String adj : myGraph.get(v)) {
					if (!visited.contains(adj)) {
						if (adj.equals(to)) {
							return true;
						}
						qu.add(adj);
						visited.add(adj);
					}
				}
			}
		}
			return false;
		

	}
}

