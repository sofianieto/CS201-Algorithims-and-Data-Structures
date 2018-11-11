public class Practice {
	
	public void dataCleanup (String[] names) {
		for(String s:names) {
			if(!(s.indexOf(",")== -1)) {
				String firstName = s.substring(s.indexOf(",")+1);
				String lastName = s.substring(0, s.indexOf(",")-1);
				s = firstName + lastName;	 
			}
		}
		for(String s:names) {
			System.out.println(s);
		}
	
}
	
	public static void main (String[]args) {
		Practice ah = new Practice();
		String[] headlines = new String[] {"John Smith", "Jones, Adam"};
		ah.dataCleanup(headlines);

	}
}
