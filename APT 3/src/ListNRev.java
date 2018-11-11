public class ListNRev {

	 public ListNode make(int n) {
		 ListNode jo = null;
		 for(int i= 1; i <= n ; i++) {
			 for(int j= i; j>0; j--) {
			 ListNode ba = new ListNode(i, jo);
			 jo = ba;
		 }
		 }
		 
         // replace statement below with code you write
         return jo;
     }
}

