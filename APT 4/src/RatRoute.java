import java.util.Arrays;

public class RatRoute {
	private char[][] myGrid;
	private int myRows, myCols;
	private int myCheeseRow, myCheeseCol;

	/**
	 * Returns the number of possible routes the rat can take to get to
	 * the cheese without ever increasing the distance between itself
	 * and the cheese at any point on its path
	 * @param enc each entry represents one row of the maze
	 */
	public int numRoutes(String[] enc) {
		// initialize instance vars
		myRows = enc.length;
		myCols = enc[0].length();
		myGrid = new char[myRows][myCols];

		int ratRow=0,ratCol=0;
		for(int r=0; r < myRows; r++){
			Arrays.fill(myGrid[r], '.');
			for(int c=0; c < myCols; c++){
				char ch = enc[r].charAt(c);
				// TODO initi

				if (ch == 'R') {
					ratRow = r;
					ratCol = c; 
				}
				else if (ch == 'C') {
					myCheeseRow = r;
					myCheeseCol = c;
					myGrid[r][c] = 'C'; 
				}
				else if (ch == 'X') {
					myGrid[r][c] = 'X'; 
				}
			}
		}
		// find current distance and count # routes
		int currentDistance = cheeseDistance(ratRow,ratCol);
		return routeCount(ratRow, ratCol, currentDistance+1);
	}

	private int cheeseDistance(int row, int col) {
		// TODO: complete cheeseDistance
		return Math.abs(row-myCheeseRow) + Math.abs(col-myCheeseCol) ;
	}

	private int routeCount(int row, int col, int dist) {
		// TODO: deal with base cases
		// 1. out of bounds
		if(row < 0 || row >= myGrid.length || col < 0|| col >= myGrid[0].length)
			return 0;
		// 2. on X
		if(myGrid[row][col] == 'X')
			return 0;
		// 3. wrong direction
		if(cheeseDistance(row,col) >= dist)
			return 0;
		// 4. at cheese
		if(row == myCheeseRow && col == myCheeseCol)
			return 1;
		// get routes in other directions
		int routes = 0;
		int currentDistance = cheeseDistance(row,col);
		// go up, left, right, down
		int[] deltaR = {-1, 0, 0, 1};
		int[] deltaC = {0, -1, 1, 0};
		for (int k =0; k < deltaR.length; k++) {
			routes += routeCount(row + deltaR[k], col + deltaC[k], currentDistance+1);
		}
		// TODO complete routeCount
		
		return routes;
	}

}


