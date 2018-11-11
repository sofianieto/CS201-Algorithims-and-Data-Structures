
public class SumSlice {
	 public int compute(int[] vals, int n) {
		 int sum = 0;
	       for(int j=n-1; j< vals.length; j+=n) {
	    	   sum += vals[j];
	       }
	       return sum;
	     }
}
