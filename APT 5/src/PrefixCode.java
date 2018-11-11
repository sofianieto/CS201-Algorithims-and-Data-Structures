import java.util.Arrays;

public class PrefixCode { 
      public String isOne(String[] words) {
          Arrays.asList(words);
          int count = 0;
          for(String w: words) {
        	  for(String f: words) {
        		  char [] fChar = f.toCharArray();
        		  char [] wChar = w.toCharArray();
        		  if(w.length() < f.length() && f != w) {
        			  int k = 0;
        			  for(int i= 0; i< wChar.length; i++) {
        				  if(fChar[i] != wChar[i]) {
        					  k = -1;
        				  }
        			  }
        			  if(k==0) {
        				  return "No, " + count;
        			  }
        			  
        		  }
        			  
        	  }
        	  count ++;
          }
          return "Yes";
      }
   }
