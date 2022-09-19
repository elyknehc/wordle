/**
 * Letter class of Wordle, stores each letter as an object and can be compared to each other, also uses a decorator method.
 * @author kylechen
 *
 */


public class Letter {

	//Initializing instance variables
	
	
	private char letter;
	private int label;
	int UNSET = 0;
	int UNUSED = 1;
	int USED = 2;
	int CORRECT = 3;
	
	/**
	 * Constructor method of Letter, initializes label to be UNSET
	 * Sets letter equal to the char value of c
	 */
	public Letter (char c) {
		label = UNSET;
		letter = c;
	
	}


	/**
	 * Compares the contents of each letter, sees if the object is a letter then compares
	 * Returns true or false whether they are equal, comparing two primitive data types
	 * @return Returns true or false
	 */
	
	public boolean equals (Object otherObject) {
		if (otherObject instanceof Letter) {
		
			if (this.letter == ((Letter)otherObject).letter) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns a string of the label based on the guess of the user
	 * Will return a value based on the match depending if it is correct
	 */
	
	
	public String decorator() {
		
		//Runs if statements to see if label is used correct or unused or not set.
		if (label == USED) {
			return "+";
		}
		else if (label == CORRECT) {
			return "!";
		}
		else if (label == UNUSED) {
			return "-";
		}
		else {
			return " ";
		}
	}
	
	/**
	 * toStirng of letter. Uses the decorator method to print the letter
	 * decorated with values representing if the users guess was correct or not
	 */
	
	public String toString() { 
		
		String result;
		
		result = decorator() + letter + decorator();
		
		return result;
	}
	

	
	/**
	 * Sets label values to unused
	 */
	
	public void setUnused() {
		label = UNUSED;
	}
	
	/**
	 * Sets label values to used
	 */
	
	public void setUsed() {
		label = USED;
	}
	
	/**
	 * Sets label values to correct
	 */
	
	public void setCorrect() {
		label = CORRECT;
	}

	
	/**
	 * Checks if label is unused or used
	 * @return true or false
	 */
	public boolean isUnused() {
		if (label == UNUSED) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Converts a string into an array of Letter objects
	 * @param s - parameter of a string
	 * @return Returns an array of letter objects, converted from the string input
	 */
	
	public static Letter[] fromString(String s) {
		Letter[] charArray =  new Letter[s.length()];
		char[] wordArray = s.toCharArray(); //Converts the string into a char array with each index of the array representing a character of the string
		
		for (int i = 0; i < s.length(); i++) {
			charArray[i] = new Letter(wordArray[i]);
		}
		//Sets up the new array of only Letter objects.
	
		return charArray;
	}
	

	
}
