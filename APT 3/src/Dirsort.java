import java.util.Arrays;
import java.util.Comparator;

public class Dirsort {


	//compare to method

	class APTComp implements Comparator<String> {
		public int compare(String a, String b) {
			String[] d1 = a.split("/");
			String[] d2 = b.split("/");
			int diff = d1.length - d2.length;
			if(diff < 0) {
				return -1;
			}
			if(diff>0) {
				return 1;
			}

			if(diff == 0) {
				for(int i=0; i< d1.length; i++) {
					int pine = d1[i].compareTo(d2[i]);
					if(pine !=0) {
						return pine;
					}
				}
				return 0;
			}
			return 0;
		}
	}

	//Implelmenting your CompareTo Method

	public String[] sort(String[] dirs) {
		Arrays.sort(dirs, new APTComp());
		return dirs;
	}
}
