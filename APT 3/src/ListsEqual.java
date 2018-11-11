import java.util.Arrays;

public class ListsEqual {




	public int equal (ListNode a1, ListNode a2) {
		ListNode first1 = a1;
		ListNode first2 = a2;
		int countera1 = 1;
		int countera2 = 1;
		if(a1 == null && a2 == null) {
			return 1;
		}
		if(a1 == null || a2 == null) {
			return 0;
		}
		
		while(a1.next != null) {
			a1 = a1.next; 
			countera1++;
		}
		while(a2.next != null) {
			a2 = a2.next; 
			countera2++;
		}
		
		int c1 = 0;
		int c2 = 0; 
		int[] co1 = new int[countera1];
		int[] co2 = new int[countera2];
		if( countera1 != countera2) {
			return 0;
		}else {
			while(first1.next != null) {
				co1[c1] = first1.info;
				c1++;
				first1 = first1.next;
			}
			co1[c1] = first1.info;
			while(first2.next != null) {
				co2[c2] = first2.info;
				c2++;
				first2 = first2.next;
			}
			co2[c2] = first2.info;
			
			if(Arrays.equals(co1, co2)) {
				return 1;
			}else {
				return 0;
			}
			
			
		}



	}
}

