/**
 * Class WordLL to store all of the guesses of the Worlde game. 
 * Central repository of the game
 * @author kylechen
 *
 */


public class WordLL {
	
	//Initalize the linked list
	private Word mysteryWord;
	private LinearNode<Word> history;

	/**
	 * Constructor method of WordLL, initializes the values of history and mysteryWord
	 * @param Mystery
	 */
	public WordLL(Word Mystery) {
		history = null;
		mysteryWord = Mystery;
	}
	
	/**
	 * Creates a linked list of all past guesses
	 * @param guess - takes 
	 * @return Returns true or false based on if the guess is correct or incorrect
	 */
	
	public boolean tryWord(Word guess) {
		
		//Create a linked list that stores all of the guesses.
		
		LinearNode<Word> current = history;
		LinearNode<Word> wordNode;
		
		//Labels the word and then stores it in a node
		
		guess.labelWord(mysteryWord);
		wordNode = new LinearNode<Word> (guess);
		
		//Calls on labelWord to return true or false from the guesses
		//determines if the guess was correct or incorrect from labelWord
		if (wordNode.getElement().labelWord(mysteryWord) == true)  {
			wordNode.setNext(history);
			history = wordNode;
			return true;
		}
		else {
			wordNode.setNext(history);
			history = wordNode;
			return false;
		}
		
	}
	
	/**
	 * Overriding toString method that returns the string representation of the WordLL object
	 * @return Returns the string representation of the linked list
	 */
	public String toString() {
		
		String result = "";
		LinearNode<Word> current = history;
		
		//Continues to add to the string result until the end of the linked list
		while (current != null) {
			result = result + current.getElement().toString() + "\n";
			current = current.getNext();

		}
		
		return result;
		
	}
}

