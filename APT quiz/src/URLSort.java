import java.util.Arrays;
import java.util.Comparator;



public class URLSort {

	class APTComp implements Comparator<String> {
		public int compare(String a, String b) {
			String[] d1 = a.split("://");
			String[] d2 = b.split("://");
			String host1 = d1[1];
			String host2 = d2[1];
			String[] host1split = host1.split(".");
			String[] host2split = host2.split(".");
			int length1 = (host1split.length -1);
			int length2 = (host2split.length -1);

			if(length1 > -1 && length2 > -1) {
				String url1 = host1split[length1];
				String url2 = host2split[length2];



				if(url1.equals("edu") && !(url2.equals("edu")) )
					return -1;
				if(url2.equals("edu") && !(url1.equals("edu")) )
					return 1;

				if(!(url1.equals("edu")) && !(url2.equals("edu"))&& url1.compareTo(url2) != 0)
					return url1.compareTo(url2);

			}


			if(length1 -1 > -1 && length2 - 1 > -1) {
				int nextCompare = host1split[length1-1].compareTo(host2split[length2-1]);
				if(nextCompare != 0)
					return nextCompare;

				/**int count =1;
			while(length1 -count > -1 && length2 - count > -1) {
				int nextCompare = host1split[length1-count].compareTo(host2split[length2-count]);
				if(nextCompare != 0)
					return nextCompare;
				else count++;
			}  **/


				if(nextCompare == 0) {
					if(length1 < length2)
						return 1;
					if(length2 < length1)
						return -1;
				}
			}

			if(d1[0].equals("https") && !(d2[0].equals("https")))
				return -1;

			if(d2[0].equals("https") && !(d1[0].equals("https")))
				return 1;

			return d1[0].compareTo(d2[0]);

		}
	}

	//Implelmenting your CompareTo Method

	public String[] sort(String[] urls) {
		Arrays.sort(urls, new APTComp());
		return urls;
	}

}
