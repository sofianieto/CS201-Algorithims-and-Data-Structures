import java.util.*;

public class FriendScore {
	public int highestScore(String[] friends) {
		ArrayList<Set<Integer>> adjList = new ArrayList<>();
		for(String s : friends) {
			Set<Integer> set = new HashSet<>();
			adjList.add(set);
			for(int k=0; k < s.length(); k++) {
				if (s.charAt(k) == 'Y') {
					set.add(k);
				}
			}
		}
		int max = 0;
		for(int k =0; k < friends.length; k++) {
			int fof= twoFriends(k, adjList);
			if (fof > max)
				max = fof;
		}
		
		return max;
	}

	private int twoFriends(int index, ArrayList<Set<Integer>> data) {
		
		Set<Integer> friends = new HashSet<>();
		friends.addAll(data.get(index));
		Set<Integer> twoF = new HashSet<>();
		for (int adj: friends) {
			twoF.addAll(data.get(adj));
		}
		twoF.remove(index);
		twoF.removeAll(friends);
		return twoF.size() + friends.size();
	}
}
