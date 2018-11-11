import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ClientsList {

	//person class
	public class Person implements Comparable<Person>{
		String first;
		String last;

		public Person(String s) {
			first = s.split(" ")[0];
			last = s.split(" ")[1];
		}

		public String getLast(){
			return last;
		}
		public String getFirst(){
			return first;
		}


		@Override
		public int compareTo(Person a) {
			String thisLast = this.getLast();
			String aLast = a.getLast();
			int diff = thisLast.compareTo(aLast);
			if(!(diff==0)) {
				return diff;
			}else {
				String thisFirst = this.getFirst();
				String aFirst = a.getFirst();
				int diff2 = thisFirst.compareTo(aFirst);

				return diff2;
			}

		}

	}



	public String[] dataCleanup(String[] names) {
		String[] newName = new String[names.length];
		int counter = 0;
		for(String s:names) {
			if(!(s.indexOf(",")== -1)) {
				String firstName = s.substring(s.indexOf(",")+2);
				String lastName = s.substring(0, s.indexOf(","));// doesn't include last index
				String so = firstName + " " + lastName;	 
				newName[counter] = so;
			}else {
				newName[counter] = s;
			}
			
			counter++;
			
		}

		//ArrayList<Person> persons = new ArrayList<Person>();
		
		Person[] persons = new Person[names.length];
		int counter2 = 0;
		for(String s: newName) {
			Person a = new Person(s);
			persons[counter2] = a;
			counter2++;
		}

		Arrays.sort(persons);

		ArrayList<String> pine = new ArrayList<String>();

		for(Person s: persons) {
			String firstName = s.getFirst();
			String lastName = s.getLast();
			String name = firstName +" " + lastName;
			pine.add(name);	
		}

		String [] countries = pine.toArray(new String[pine.size()]);

		return countries;

	}

	public static void main (String[]args) {
		ClientsList ah = new ClientsList();
		String[] headlines = new String[] {"John Smith", "Jones, Adam"};
		ah.dataCleanup(headlines);

	}

}

