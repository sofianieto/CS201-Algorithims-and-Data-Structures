

public class tester {
	
	public int compare(String v, String w) {
		

			int comp = 4;
			String vShort;
			String wShort;

			if(v.length() <= (comp+1) && w.length() <= (comp+1)) {
				vShort = v;
				wShort = w;
			}
			if(v.length() <= (comp+1) && w.length() > (comp+1)) {
				vShort= v;
				wShort= w.substring(0,comp);
			}
			if(v.length() > (comp+1) && w.length() <= (comp+1)) {
				vShort= v.substring(0,comp);
				wShort= w;
			}else {
				vShort= v.substring(0,comp);
				wShort= w.substring(0,comp);
			}

			return vShort.compareTo(wShort);
	}
	

	public static void main (String[]args) {
		tester myAnon = new tester();
		
		System.out.println(myAnon.compare("bee", "beekeeper"));
}
}