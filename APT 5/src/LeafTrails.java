
import java.util.TreeMap;

public class LeafTrails {

	

	public String[] trails(TreeNode roots) {
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
		if(roots == null || (roots.left == null && roots.right == null)){
			return new String[0];
		}
		if(roots.left != null)
		makeCodingsFromTree(roots.left, "0", tmap);
		if(roots.right != null)
		makeCodingsFromTree(roots.right, "1", tmap);
		

		String[] codes = new String[tmap.size()];
		int ah = 0;
		for(Integer jon: tmap.keySet()) {
			codes[ah] = tmap.get(jon);
			ah++;
		}
		return codes;
	}

	private void makeCodingsFromTree(TreeNode root,String str, TreeMap<Integer, String> codings) {
		if(root.left == null && root.right == null) {
			codings.put(root.info, str);
		}

		if (root.left != null) {
			makeCodingsFromTree(root.left, str + "0", codings);
		}

		if (root.right != null) {
			makeCodingsFromTree(root.right, str + "1", codings);
		}

	}
}
