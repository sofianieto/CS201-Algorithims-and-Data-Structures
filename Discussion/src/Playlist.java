import java.util.HashMap;
import java.util.TreeSet;

public class Playlist {
	String topSong(String[] playlists) {
		HashMap<String, Integer> songMap = new HashMap<>();
		int count = 0;
		for (int i = 0; i<playlists.length; i++) {
			String[] oneList = playlists[i].split(",");
			for (int j = 0; j<oneList.length; j++) {
				String newKey = oneList[j];
				if (! songMap.containsKey(newKey)) {
				count = 1;
				songMap.put(newKey, count);
				} else {
					count = (songMap.get(newKey));
					count += 1;
					songMap.put(newKey, count);
				}
			}
			}
		int max = 0;
		String maxSong = "";
		TreeSet<String> songKeys = new TreeSet<>(songMap.keySet());
		String[] songs = songKeys.toArray(new String[0]);
		for (int i = 0; i < songs.length; i++) {
			if (max < songMap.get(songs[i])) {
			max = songMap.get(songs[i]);
			maxSong = songs[i];
			} 
		}
		return maxSong;
	}
	}
