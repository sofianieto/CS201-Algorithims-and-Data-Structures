import java.util.*;
public class Circuits {
	
	public int[][]adjMatrix;
	public int[][]pathWeights;
	
	public int howLong(String[] connects, String[] costs) {
		adjMatrix = new int[connects.length][connects.length];
		for(int i = 0; i <connects.length;i++) {
			String[] edges = connects[i].split(" ");
			String[] weights = costs[i].split(" ");			
			for(int j = 0; j<edges.length;j++) {
				if(!(edges[j].equals("")))
				adjMatrix[i][Integer.parseInt(edges[j])] = Integer.parseInt(weights[j]);
			}	
		}
		pathWeights = new int[connects.length][connects.length];
		for(int start = 0; start < adjMatrix.length;start++) {
			// traverse to some vertex n by BFS or DFS
			// every time you reach a path end, store the cost of the path 
			// at each level increment path weights
			// if the path weight is greater than the max that we've already seen,
			// if w > pathWeights[start][end], then pathWeights[start][end] is set to w
			// set it as the end pathWeights[start][end]	
			dfs(start, start, 0);
		}
		
		// then loop through pathWeights and find the biggest value and return that
		int max = 0;
		for(int i = 0; i < adjMatrix.length;i++) {
			for(int j = 0; j< adjMatrix[i].length;j++) {
				if(pathWeights[i][j] > max) {
					max = pathWeights[i][j];
				}
			}
		}
		return max;
	
	}
	// start = node we started recursing at, curr = node we are currently at
	// weight is weight it has currently taken to get from start to curr
	public void dfs(int start, int curr, int weight) {
		if(pathWeights[start][curr] < weight){
			pathWeights[start][curr] = weight;
		}
		for(int i = 0; i< adjMatrix[curr].length;i++) {
			if(adjMatrix[curr][i] > 0) {
				dfs(start,i,weight + adjMatrix[curr][i]);
			}
		}
	}

}
