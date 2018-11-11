
public class ClassScores {
	public int[] findMode(int[] scores) {
        int[] scorecount = new int[scores.length];
        for(int x = 0; x< scores.length; x++) {
        int a = scores[x];
        int xo = 0;
        for(int y = 0; y< scores.length; y++) {
        	int d = scores[y];
        	if(d == a)
        		xo++;
        }
        scorecount[x]= xo;
        }
        
        // fill in code here
        
        return null;
    }
	
}
