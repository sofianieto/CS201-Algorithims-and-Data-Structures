import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public class EfficientMarkov extends MarkovModel {
	Map<String,ArrayList<String>> myMap;

	public EfficientMarkov(int order) {
		super(order);
		myMap = new HashMap<String, ArrayList<String>>();
	}

	public void setTraining(String text) {
		myText =text;
		myMap.clear();
		for(int i=0; i < (text.length()-myOrder+1); i++ ) { 
			String miniStr = text.substring(i,i+myOrder);
			if (! myMap.containsKey(miniStr)){
				myMap.put(miniStr, new ArrayList<String>());
			}
			if (i == (text.length()- myOrder)) {
				myMap.get(miniStr).add(PSEUDO_EOS);
			}
			if (i < (text.length()- myOrder)) {
				myMap.get(miniStr).add(text.substring(i+myOrder,i+myOrder+1));

			}


		}


	}




	public ArrayList<String> getFollows(String key){
		if(myMap.containsKey(key)) {
			return myMap.get(key);
		}
		else {
			throw new NoSuchElementException(key);
		}
	}
}






