public class ListCount {
	
/**	public class ListNode {
	    int info;
	    ListNode next;
	    ListNode(int x){
	        info = x;
	    }
	    ListNode(int x, ListNode node){
	        info = x;
		next = node;
	    }
	} **/

	 public int count (ListNode list) {
		 int counter = 0;
		 if(list == null) {
			 return 0;
		 }
         while(list != null) {
        	 counter++;
        	 list = list.next;
         }
	  return counter;
     }
}
