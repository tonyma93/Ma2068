package lab5;

import java.util.ArrayList;
import java.util.List;

public class IndexNode  {

	// The word for this entry
	String word;
	// The number of occurences for this word
	int occurences;
	// A list of line numbers for this word.
	List<Integer> list; 
	
	IndexNode left;
	IndexNode right;
	
	
	//Constructors
	
		public IndexNode(String word, int lineNumber) {
			list = new ArrayList<Integer>();
			this.word = word;
			this.list.add(lineNumber);
			this.left = null;
			this.right = null;
			this.occurences = 1;
	}


	// Complete This
	// return the word and the lines it appears on.
	// string must be one line
	public String toString(){
		return this.word.toString();
	}
	
	
	
}