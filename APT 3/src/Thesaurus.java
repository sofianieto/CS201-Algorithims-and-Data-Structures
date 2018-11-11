import java.util.*;

/**
 * Name: YOUR NAME HERE 
 * Course: CompSci 201 
 * Problem: Discussion 3 
 * Date: February 5, 2018 
 * Purpose: Solve a problem by applying some set operations
 */

public class Thesaurus {
    /**
     * Converts the elements of a String to a set. The format of a n-word String
     * should be "word1 word2 word3... wordn" That is, each word should be
     * separated by exactly one space and there should be no leading or trailing
     * spaces.
     * 
     * @param s
     *            words with individual spaces separating words
     * @return elements of s as a Set
     */
    public TreeSet<String> sToSet(String s) {
	String[] ban = s.split(" ");// TODO: complete sToSet
	return new TreeSet<String>(Arrays.asList(ban));
    }
    
    /**
     * Converts the elements in a collection to a space-separated list. That is,
     * if the collection contains [A, B, C, D], the method should return
     * "A B C D". There should be no leading or trailing spaces
     * 
     * @return the elements of elems as a space-separated String
     */
    public String collToS(Collection<String> elems) {
    	String[] a = elems.toArray(new String[0]);
		String str = String.join(" ", a);
		return str;
    }
    
    /**
     * Returns the number of elements contained in both sets. The sets passed in
     * should not be changed.
     * 
     * @param a
     *            a set of words
     * @param b
     *            another set of words
     * @return number of elements in common to a and b
     */
    public int numInCommon(Set<String> a, Set<String> b) {
    	TreeSet <String> c = new TreeSet<> ();
		c.addAll(a);
		c.retainAll(b);

		return c.size();
    }
    
    /**
     * Creates a new set that is the union of the given sets. The union of two
     * sets is the set that contains all of the elements of both sets. The sets
     * passed in should not be changed.
     *
     * @param a
     *            a set of words
     * @param b
     *            another set of words
     * @return union of sets a and b
     */
    public Set<String> union(Set<String> a, Set<String> b) {
	// TODO: test union
	TreeSet<String> results = a;
	results.addAll(b);
	return results;
    }
    
    /**
     * Creates an edited version of Thesaurus entries.
     * 
     * If any two entries have 2 or more words in common then they should be
     * combined into a single entry. The final Thesaurus must contain no pair of
     * entries that have 2 or more words in common. Each entry must contain no
     * duplicates. The words within each element of the returned value must be
     * in alphabetical order, and the elements must appear in alphabetical order
     * 
     * @param entry
     *            each element is a list of words that are all synonyms
     * @return edited version of Thesaurus entries
     */
    public String[] edit(String[] entry) {
	// TODO: Convert entry from array of Strings to ArrayList of Sets
    	ArrayList<TreeSet<String>> ah = new ArrayList<TreeSet<String>>();
    	for(int i = 0; i < entry.length; i++) {
    		ah.add(sToSet(entry[i]));
    	}
    	ArrayList<TreeSet<String>> bah = new ArrayList<TreeSet<String>>();
    	
	// TODO: Create edited version of entries
    	for(int i = 0; i< ah.size(); i++) {
    		for(int j= i+1; j < ah.size(); i++)
    	}
	
	// TODO: Sort entries in alphabetical order
	
	return entry;
    }
    
    public static void main(String[] args) {
	Thesaurus t = new Thesaurus();
	String[][] inputs = { { "ape monkey wrench", "wrench twist strain", "monkey twist frugue strain" },
			      { "C B A", "F D E", "I G H", "B G C E F" } };
	for (String[] input : inputs)
	    System.out.println(Arrays.toString(t.edit(input)));
	// TODO: add more tests
    }