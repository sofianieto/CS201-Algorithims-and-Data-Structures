import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;


public class Internet {

	Map<Integer, ArrayList<Integer>> myGraph = new TreeMap<Integer, 
			ArrayList<Integer>>();

	public void fillMap(String[] adjList) {
		for(int i= 0; i< adjList.length; i++) {
			ArrayList<Integer> pa = new ArrayList<Integer>();
			String[] stringNum = adjList[i].split(" ");
			for(int b= 0; b< stringNum.length; b++)
			{
				pa.add(Integer.valueOf(stringNum[b]));
			}
			myGraph.put(i , pa);

		}
	}

	/**
	 * Return the number of nodes accessible from start - assuming avoid is not in
	 * the graph
	 */
	public int reachable(int start, int avoid) {
		// TODO complete reachable so that it does not go through avoid
		Set<Integer> visited = new HashSet<Integer>();
		Queue<Integer> qu = new LinkedList<Integer>();
		visited.add(start);
		qu.add(start);

		while (qu.size() > 0) {
			int v = qu.remove();
			for (int adj : myGraph.get(v)) { // Iterates through v's array attached to 
				if (!visited.contains(adj) && adj != avoid) {
					visited.add(adj);
					qu.add(adj);
				}
			}
		}
		
		return visited.size();
	}

	public int articulationPoints(String[] routers) {

		fillMap(routers);

		int badpoint = 0;

		for(int i = 0; i < routers.length; i++) {
			if(i==0) {
				if(reachable(1,i) != (routers.length-1)) {
					badpoint+=1;
				}
			}else {
				if(reachable(i-1,i) != (routers.length-1))
					badpoint+=1;
			}
		}
		// TODO complete articulationPoints

		return badpoint;
	}

	public static void main(String[] args) {
		String[][] input = { { "2", "2 3", "0 1 3 4", "1 2", "2 5 6", "4 6", "4 5" },
				{ "3 10", "8 4", "7 10", "0 9", "6 1", "9", "4 11", "11 2", "1", "3 5", "0 2", "7 6" },
				{ "1 9", "0 2", "1 3", "2 4", "3 5", "4 6", "5 7", "6 8", "7 9", "8 0" },
				{ "1 7 12 13 15", "0 2 6 4 7", "3 5 6 1", "4 5 2", "3 1", "3 2", "2 1", "1 0 8", "7 9 10 11", "10 11 8",
					"9 8", "9 8", "0 13", "0 12 14 15", "13", "13 0" } };
		Internet run = new Internet();
		for (String[] routers : input) {
			int artics = run.articulationPoints(routers);
			System.out.printf("%s -> %d\n", Arrays.toString(routers), artics);
		}

	}

}
