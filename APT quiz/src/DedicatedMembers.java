import java.util.ArrayList;
import java.util.TreeSet;


public class DedicatedMembers {
	public int[] unique(String[] clubs) {
		ArrayList<TreeSet<String>> result = new ArrayList<TreeSet<String>>();
		ArrayList<TreeSet<String>> extraResult = new ArrayList<TreeSet<String>>(result);
		for(int j=0; j< clubs.length; j++) {
			String s = clubs[j];
			s = s.toLowerCase();
			String[] seperated= s.split("\\s+");
			TreeSet<String> bo = new TreeSet<String>();
			for(String l:seperated) {
				bo.add(l);
			}
			result.add(bo);
		}
		
		for(int j=0; j< clubs.length; j++) {
			String s = clubs[j];
			s = s.toLowerCase();
			String[] seperated= s.split("\\s+");
			TreeSet<String> bo = new TreeSet<String>();
			for(String l:seperated) {
				bo.add(l);
			}
			extraResult.add(bo);
		}
		
		
		for(int q=0; q< extraResult.size(); q++) {
			for(int qo = 0; qo < extraResult.size(); qo++) {
				if(q != qo) {
					TreeSet<String> al = new TreeSet<String>(extraResult.get(q));
					result.get(q).removeAll(extraResult.get(qo));
					result.get(qo).removeAll(al);
				}
				
			}
			
		} 
	
			int[] endResult = new int[result.size()];
			for(int j=0; j < endResult.length; j++) {
				endResult[j]= result.get(j).size();
			}

			return endResult;
	}
	}

