import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Anonymous {
	
	public int howMany(String[] headlines, String[] messages) {

		ArrayList<String> listHeadlines = new ArrayList<String>();
		
		for(String s: headlines) {
			s = s.toLowerCase();
			s = s.replaceAll("\\s+","");
			String[] seperated= s.split("");
			listHeadlines.addAll(Arrays.asList(seperated)); // because you can't add array to array list 
		}

		//System.out.print(listHeadlines.toString());

		int counter = 0;
		for(String s: messages) {
			if(s.length() <= 1) {
				counter++;
				continue;
			} 
			
			ArrayList<String> listMessages = new ArrayList<String>();
			s = s.toLowerCase();
			boolean makeMessage = true;

			s=s.replaceAll("\\s+","");
			String[] seperated= s.split("");
			listMessages.addAll(Arrays.asList(seperated));
			for(String k:listMessages) {
				if (Collections.frequency(listHeadlines,k)>= Collections.frequency(listMessages, k)) {
					continue;
				}
				else {
					makeMessage = false;
				}
			}
			
			if(makeMessage) {
				counter ++;
			}


		}
		
		return counter;
	}



	public static void main (String[]args) {
		Anonymous myAnon = new Anonymous();
		String[] headlines = new String[] {"fsdsffsd "};
		String[] messages = new String[] {" "};
		System.out.print(myAnon.howMany(headlines,messages));

	}
	
	
}
