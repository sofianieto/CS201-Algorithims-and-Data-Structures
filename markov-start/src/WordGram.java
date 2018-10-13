
public class WordGram implements Comparable<WordGram>{
	
	private String[] myWords;
	private int myHash;
	
	public WordGram(String[] words, int index, int size) {
		// complete this constructor
		
		myWords = new String[size];
		for(int i=0; i < size; i++) {
			myWords[i] = words[index+ i ];
		}
		myHash = 17;

	}
	
	@Override
	public int hashCode() {
		int hash = 37;

		for(int k=0; k< myWords.length; k++) {
			hash += k*k*31*myWords[k].hashCode();
		}
		myHash = hash;
		return myHash; 
	}
	
	@Override
	public String toString() {
		String joined = String.join(" ", myWords);
		return joined;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null || ! (other instanceof WordGram)) {
			return false;
		}
			WordGram wg = (WordGram) other; //specificies object -> cannot be in if statement since used later you have to guarantee that it exists
		if ( this.myWords.length != wg.myWords.length) {
			return false;
		}
		for(int i=0; i < myWords.length; i++) {
			String myW = this.myWords[i];
			String wgString = wg.myWords[i];
			if (! myW.equals(wgString)) {
				return false;
		}
		}
		return true;
	}
	
	@Override
	public int compareTo(WordGram wg) {
		// this is less than parmeter -> -1
		// this when equal to parameter -> 0
		// this when greater than parameter -> 1 
		if(this.equals(wg)) {
			return 0; 
		}
		
		int output = 0; 
		
		for(int i=0; i<this.length() && i<wg.length(); i++) {
			if(this.myWords[i].compareTo(wg.myWords[i]) !=0) {
				output=1;
				return this.myWords[i].compareTo(wg.myWords[i]);
				
			}
			
			}
		if(output == 0) {
			if(this.length()> wg.length()) {
			return 1;
		}
			else {
				return -1;
			}
			}
		return 0;
		}
		
		
	
	public int length() {
		return this.myWords.length;
	}
	
	public WordGram shiftAdd(String last) {
		String[] holder = new String[myWords.length];
		for(int i=1; i < myWords.length ; i++) {
			holder[i-1] = myWords[i];
		}
		holder[holder.length-1] = last;
		return new WordGram(holder,0,myWords.length);
	}
}
