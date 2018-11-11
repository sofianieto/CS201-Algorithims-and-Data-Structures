import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VoteRigging {
	public int minimumVotes(int[] votes) {
	List<Integer> list = new ArrayList<>();
	for(int k : votes) list.add(k);
			
	int stolen = 0;
	List<Integer> others = list.subList(1,list.size());	
	if(others.size() > 0){
	while (list.get(0) <= Collections.max(others)) {
	  Collections.sort(others,Comparator.reverseOrder());
	  list.set(0, list.get(0) + 1);
	  others.set(0, others.get(0) - 1);
				
	  stolen += 1;
	}
	}
	return stolen;
	}
}
