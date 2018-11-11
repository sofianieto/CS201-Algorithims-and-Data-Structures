import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;



public class SyllableSorting {


	public String[] Breakdown(String word) {
		String[] seperated= word.split("");
		ArrayList<String> syllables = new ArrayList<String>();
		ArrayList<String> vowels = new ArrayList<String>();
		vowels.add("a");vowels.add("e");vowels.add("i");vowels.add("o");vowels.add("u");
		StringBuilder syl = new StringBuilder();
		for(int i=0; i< seperated.length; i++) {
			if(i == seperated.length-1) {
				syl.append(seperated[i]);
				syllables.add(syl.toString());
			}else{
				if(vowels.contains(seperated[i])& !vowels.contains(seperated[i+1])) {
					syl.append(seperated[i]);
					syllables.add(syl.toString());
					syl.delete(0, syl.length());
				}
				if(!vowels.contains(seperated[i])) {
					syl.append(seperated[i]);
				}
				if(vowels.contains(seperated[i])& vowels.contains(seperated[i+1])) {
					syl.append(seperated[i]);
				}
			}
		}

		String [] countries = syllables.toArray(new String[syllables.size()]);
		return countries;
	}

	class APTComp implements Comparator<String> {
		public int compare(String a, String b) {
			String[] d1 = Breakdown(a);
			String[] d2 = Breakdown(b);
			String[] d3 = Breakdown(a);
			String[] d4 = Breakdown(b);
			Arrays.sort(d1);
			Arrays.sort(d2);
			int pine = 0;
			int all = 0;
			for(int i=0; i < d1.length && i < d2.length; i++) {
				pine = d1[i].compareTo(d2[i]);
				if(pine !=0) {
					return pine;
				}
			}
			if(pine==0) {
				int bar = d1.length - d2.length;
				if(bar != 0) {
					return bar;
				}else {
				for(int i=0; i < d3.length && i < d4.length; i++) {
					all = d3[i].compareTo(d4[i]);
					if(all !=0) {
						return all;
					}
				}
				}
			}
			return 0;

		}
	}
	public String[] sortWords(String[] words) {
		Arrays.sort(words, new APTComp());
		return words;
	}

}


/**public static void main (String[]args) {
		SyllableSorting myAnon = new SyllableSorting();
		String[] bb = myAnon.Breakdown("bainana");
		for(String i: bb) {
			System.out.println(i);
		} **/	



