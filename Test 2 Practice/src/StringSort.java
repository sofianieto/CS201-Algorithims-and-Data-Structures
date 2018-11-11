import java.util.Arrays;
import java.util.Comparator;


public class StringSort {
	class APTComp implements Comparator<String> {
		public int compare(String a, String b) {
			String[] d1 = a.split("");
			String[] d2 = b.split("");
			int diff = d1.length - d2.length;
			if(diff < 0) {
				return diff;
			}
			if(diff> 0) {
				return diff;
			}

			return a.compareTo(b);
		}
		/**public int compare(String a, String b) {
			String[] d1 = a.split("/");
			String[] d2 = b.split("/");
			int diff = d1.length - d2.length;
			if(diff < 0) {
				return 1;
			}
			if(diff > 0) {
				return -1;
			}else{ 
				a.compareTo(b);
			}
			return 0;
		} **/
	}
	
public String[] sort(String[] words) {
	Arrays.sort(words, new APTComp());
	return words;
}
}
// -1 when first one is less than second (belongs after)
// 0 when equal
// 