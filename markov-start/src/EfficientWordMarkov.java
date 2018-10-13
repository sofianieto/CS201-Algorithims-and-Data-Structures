import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class EfficientWordMarkov extends WordMarkovModel {
	Map<WordGram,ArrayList<String>> myMap;
String inText;

	public EfficientWordMarkov(int order) {
		super(order);
		myMap = new HashMap<WordGram, ArrayList<String>>();
	}

	public void setTraining(String text) {
		myMap.clear();
		super.setTraining(text);
		for(int i=0; i < (myWords.length -myOrder+1); i++ ) { 
			WordGram miniStr = new WordGram(myWords,i,myOrder);
			if (! myMap.containsKey(miniStr)){
				myMap.put(miniStr, new ArrayList<String>());
			}
			if (i == (myWords.length- myOrder)) {
				myMap.get(miniStr).add(PSEUDO_EOS);
			}
			if (i < (myWords.length- myOrder)) {
				myMap.get(miniStr).add(myWords[i+myOrder]);

			}


		}


	}




	public ArrayList<String> getFollows(WordGram key){
		if(myMap.containsKey(key)) {
			return myMap.get(key);
		}
		else {
			throw new NoSuchElementException("Element not there");
		}
	}
}
