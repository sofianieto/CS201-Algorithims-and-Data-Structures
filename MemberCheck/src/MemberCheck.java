import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class MemberCheck {
	public String[] whosDishonest(String[] club1, 
			String[] club2, 
			String[] club3) {
		// Adding clubs to sets
		/*HashSet <String> C1 =new HashSet<> (Arrays.asList(club1));
		HashSet <String> C2= new HashSet<> (Arrays.asList(club2));
		HashSet <String> C3= new HashSet<> (Arrays.asList(club3));

		HashSet <String> S1 = new HashSet<> (Arrays.asList(club1));
		HashSet <String> S2 = new HashSet<> (Arrays.asList(club2));
		HashSet <String> S3 = new HashSet<> (Arrays.asList(club3)); */
		
		
		
		// as micheal how -> ArrayList<String> CO = new ArrayList<String>(Arrays.asList(club1));
		HashSet <String> C1 =new HashSet<> (Arrays.asList(club1));
		HashSet <String> C2= new HashSet<> (Arrays.asList(club2));
		HashSet <String> C3= new HashSet<> (Arrays.asList(club3));

		HashSet <String> S1 = new HashSet<> (Arrays.asList(club1));
		HashSet <String> S2 = new HashSet<> (Arrays.asList(club2));
		HashSet <String> S3 = new HashSet<> (Arrays.asList(club3));
		
		
		// comparing members who visited multiple clubs
		S1.retainAll(C2);
		S2.retainAll(C3);
		S3.retainAll(C1);

		//adding to new set

		TreeSet<String> result = new TreeSet<>();

		result.addAll(S1);
		result.addAll(S2);
		result.addAll(S3);

		//Set to array
		return result.toArray(new String[0]);

	}

	
}


//HashSet < String> S1 = new Hashset<> (ArraysasList(club1)) 
//-> can only put lists in arrays not 
//String[0] makes sure you get a string back, not an object

/* 
s1.addAll(s2) — transforms s1 into the union of s1 and s2. 
(The union of two sets is the set containing all of the elements contained in either set.)
*/

/* s1.retainAll(s2) — transforms s1 into the intersection of s1 and s2. 
(The intersection of two sets is the set containing only the elements common to both sets.)

here s1 and s2 are sets
*/

/*public static void main (String[]args) {
	String[] club1  = new String[] {"JOHN","JOHN","FRED","PEG"};
	String[] club2 = new String[]{"PEG","GEORGE"};
	String[] club3 = new String[]{"GEORGE","DAVID"};
	
	String[] dishonest= whosDishonest(club1,club2,club3);
	
	System.out.print(dishonest);
	
} */

