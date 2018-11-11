import java.util.ArrayList;
import java.util.Collections;

public class SpreadingNews {
	// for every person, who is his or her supervisor
	private int[] mySups;
	// for every person, who are his or her subordinates
	private ArrayList<ArrayList<Integer>> mySubs;
	/** -> Seperate for loops?
	 * 
	 **/
	//initializing?
	public int minTime(int[] supervisors) {
		mySups = supervisors;
		mySubs = new ArrayList<>();
		// make space for a list for every person
		for (int k = 0; k < supervisors.length; k++) 
			mySubs.add(new ArrayList<Integer>());

		for (int k = 0; k < supervisors.length; k++) 
			if (mySups[k] != -1)
				mySubs.get(mySups[k]).add(k);
		
		return minTime(0);
	}

	public int minTime(int bossIndex) {
		ArrayList<Integer> subTimes = new ArrayList<>();//by the end this will have all of the times from the subs
		if(mySubs.get(bossIndex).size()==0) {
			return 0;
		}
		for (int i : mySubs.get(bossIndex)) {
			subTimes.add(minTime(i)); // which min time is this making a call itself?
		}
		
		Collections.sort(subTimes, Collections.reverseOrder()); 

		int count = 0;
		for(int k=0; k< subTimes.size(); k++) {
			count= Math.max(count, subTimes.get(k) +1 +k); 
		}
		return count;
	}
}
