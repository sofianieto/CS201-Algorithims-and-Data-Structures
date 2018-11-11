import java.util.Arrays;

public class BSTcount {
	private long[] myMemo;
	
	public long howMany(int[] values) {
		myMemo= new long[values.length +1];
		
		Arrays.fill(myMemo,-1);
				return howMany(values.length);
	}
		
	public long howMany(int size) {
		//base case
		if(size == 0)
			return 1;
		if(myMemo[size] != -1)
			return myMemo[size];
		//recursive cases
		long total = 0;
		for (int left = 0; left < size; left ++)
			total += howMany(left) *howMany(size- left -1);
		myMemo[size] = total;
		return total;
		
	}
}
