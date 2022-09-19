/**
 * Class represents a word object. A word object is stored into a linked list and can be used to label
 * guesses - identifying if they are correct or not.
 * @author kchen727, Kyle
 *
 */
public class Word {

	private LinearNode<Letter> firstLetter;
	

	/**
	 * Sets up a linked list of the letter object, each node stores a letter.
	 * @param letters - Letter array of letter objects as a parameter
	 */
	public Word (Letter[] letters) {
		
	//Initializing the linked list of the Word class
		
	LinearNode<Letter> current = firstLetter;
	LinearNode<Letter> charNode;
	
		for (int i = letters.length-1; i >= 0; i--) {
			
		//Setting up the nodes, adding each preceding character to the end of the list.
			
			charNode = new LinearNode<Letter> (letters[i]);
			// add to head of the linked list
			charNode.setNext(firstLetter);
			firstLetter = charNode;
		}
		
			
	}
	
	/**
	 * toString overriding the old toString method. 
	 * @return Returns a string representation of the entire linked list.
	 */
	public String toString() {
		
		String result = "Word: ";
		
		LinearNode<Letter> current = firstLetter;
		
		while (current != null) {
			//Invoke letter's toString method for each character
			result = result + current.getElement().toString() + " ";
			current = current.getNext();
		}
		
		return result;
	}
	
	/**
	 * Decorates the contents of the linked list
	 * @param mystery - Guessed word
	 * @return Returns the labeled version of the linked list
	 */
	public boolean labelWord(Word mystery) {
		
		//Initialize counters to compare indices 
		
		int wordleCounter = 0;
		int mysteryCounter = 0;
		
		//Set up linked list
		
		LinearNode<Letter> current = firstLetter;
		LinearNode<Letter> currentMysteryNode = mystery.firstLetter;
		
		//Check to see if the two words that have been guessed are the same two words
		
		//While loop to compare two 
		while (current != null || currentMysteryNode != null) {
			
			if (current == null || currentMysteryNode == null) { //Added this for a test case, fixes a case.
				break; 
			}
			
			//If both elements are the same, then they will be set to correct
			if (current.getElement().equals(currentMysteryNode.getElement())) {
				current.getElement().setCorrect();
				}
			
			//If at any point they are not, then break
			else {
				break;
			}
			//If we reach the end of the linked list without breaking, then it will return true
			if (currentMysteryNode.getNext() == null && current.getNext() == null) {
				return true; //Both words will be equal - all set to correct
			}
			
			//Continues through the linked lists
			current = current.getNext();
			currentMysteryNode = currentMysteryNode.getNext();
		}
		
		//If we break out of the loop, we run another one to compare indices again, setting up a nested while loop
		
		
		//Default set everything to unused
		while (current != null) {
			current.getElement().setUnused();
			current = current.getNext();
		}
		
		current = firstLetter;
		
		while (current != null) {
			
			//Initialize counters
			currentMysteryNode = mystery.firstLetter;
			mysteryCounter = 0;
			
			while (currentMysteryNode!= null) {
				//We want to compare every element in the linked list of mystery to the Wordle answer
				//If they are equal, we can set it to correct or used based on the position of the indices
				if (current.getElement().equals(currentMysteryNode.getElement())) {
					
					//If the indices are at the same point, we can set it to correct
					if (mysteryCounter == wordleCounter) {
						current.getElement().setCorrect();
					}
					
					//Otherwise, it is used at some point
					else {
					current.getElement().setUsed();
					}
					
					//Add to the counters and continue through the list, we don't need to check for equality 
					currentMysteryNode = currentMysteryNode.getNext();
					break;
				}
				
				//If there are no matches, we set the element to unused
				else {
					current.getElement().setUnused();
				}
				
				//Continue through the mystery linked list and continue to compare with the mysteryNode linked list
				mysteryCounter = mysteryCounter + 1;
				currentMysteryNode = currentMysteryNode.getNext();
			}
			
			//Continue through the wordle counter and the current linked list
			wordleCounter = wordleCounter+1;
			current = current.getNext();
		}
		
		return false; //Since they are not equal, return false

	}
}
