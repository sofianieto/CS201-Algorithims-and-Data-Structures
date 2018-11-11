
public class TypingJob {

	public int bestTime(int[] pages) {
		// TODO complete bestTime(int[])
		return bestTime(pages, 0, 0, 0, 0);
	}

	/**
	 * returns minimum number of  minutes to type papers in pages
	 * starting with index-th paper and given minutes assigned to typists
	 * @param pages number of pages for each paper
	 * @param index of paper to start with. That is, consider papers[index,papers.length-1]
	 * @param t1 number of pages typed so far by typist 1
	 * @param t2 number of pages typed so far by typist 2
	 * @param t3 number of pages typed so far by typist 3
	 * @return minimum number of pages to type all papers given current
	 * assignment
	 */
	public int bestTime(int[] pages, int index, int t1, int t2, int t3) {
		if(pages == null || pages.length == 0)
			return 0;
		if(index >= pages.length)
			return Math.max(t1, Math.max(t2, t3));
		int assign1 = bestTime(pages, index +1, t1 + pages[index], t2, t3); // checking what happens if you assign to T1
		int assign2 = bestTime(pages, index +1, t1 , t2 + pages[index], t3); // checking what happens if you assign to T2
		int assign3 = bestTime(pages, index +1, t1 , t2, t3 + pages[index]); // checking what happens if you assign to T3
		return Math.min(assign1, Math.min(assign2, assign3));
	}
/** Okay so you start at index 0 
 * assign1/2/3 -> it will go and call best time until it reaches end makes tree kinda
 * assign 1 calls best time and makes assign1,2,3 for index+1 one till end -> then returns minimum
 * and minimum and minimum case untilyou ultimately get your minimum case -> but what is returned is the max
 * typist of that minimum case
 * 
 **/
	/**public static void main(String[] args) {
		// TODO add test cases
		int[][] tests = {
				{1,2,3,4,5,6,7},
				{3,3,3,5,9,10,10},
				{100, 35, 13, 83, 4, 95, 62, 13, 100, 70}};
		TypingJob obj = new TypingJob();
		for (int[] t: tests) {
			System.out.println(obj.bestTime(t));
		} 
	} **/
}
