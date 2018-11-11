import java.util.ArrayList;
import java.util.Collections;

public class BSTRange {
	public int[] range(TreeNode t, int low, int high) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		if(t == null)
			return new int[0];

		if(t.info <= high && t.info >= low) {
		al.add(t.info);
		}
		
		if(t.left != null) {
			int[] ba = range(t.left, low , high);
			for(int i=0; i < ba.length; i++) {
				al.add(ba[i]);
			}
		}


		if(t.right !=  null ) {
			int[] ba = range(t.right, low, high);
			for(int i=0; i < ba.length; i++) {
				al.add(ba[i]);
			}
		}
		Collections.sort(al);

		int[] leaves = new int[al.size()];
		for(int i=0; i< leaves.length; i++)
		{
			leaves[i] = al.get(i).intValue();	
		}
		return leaves;
	}

}


