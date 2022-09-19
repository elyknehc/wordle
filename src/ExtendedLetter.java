/**
 * ExtendedLetter class inherits the Letter class and adds additional features
 * @author kylechen
 *
 */
public class ExtendedLetter extends Letter {
	
	//Initialize instance variables and their values
	private String content;
	private int family;
	private boolean related;
	private int SINGLETON = -1;
	
	/**
	 * Constructor method of ExtendedLetter. Initializes values of content, related and family and calls on super to inherit from Letter.
	 * @param s - A string input from the user
	 */
	public ExtendedLetter(String s) {
		super('c');
		content = s;
		related = false;
		family = SINGLETON;
	}
	
	/**
	 * Overloaded constructor of ExtendedLetter, containing family as an additional parameter
	 * @param s - a string to call on the super of Letter
	 * @param fam - takes in parameter fam, to determine if extendedLetter objects are related
	 */
	public ExtendedLetter(String s, int fam) {
		super('c');
		content = s;
		related = false;
		family = fam;
		
	}
	
	/**
	 * Overriding equals method, comparing to see if two ExtendedLetter objects are the same 
	 */
	public boolean equals(Object other) {
		
		//Checks the class of the object first, then sets related to true
		
		if (other instanceof ExtendedLetter) {
			if (this.family == ((ExtendedLetter)other).family) {
				related = true;
				
				//If the content is equal, then return true
				if (this.content.equals(((ExtendedLetter)other).content)) {
					return true;
				}
				//Otherwise will return false in other cases
				else {
					return false;
				}
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
	 * Overriding toString method of Letter
	 * Returns the string representation of the ExtendedLetter, using the decorator
	 */
	public String toString() {
		
		String result = "";
		//If related then will print with "."
		if (decorator() == "-" && related == true) {
			result = "." + content + ".";
			return result;
		}
		//Otherwise, call on the decorator
		else {
			result = decorator() + content + decorator();
			return result;
		}
	}
	
	/**
	 * 
	 * @param content - content of the extendedLetter
	 * @param codes - parameter determining the family and if the codes are equal
	 * @return - returns a ExtendedLetter array with the values set up.
	 */
	public static Letter[] fromStrings(String[] content, int[] codes) {
		
		ExtendedLetter[] extendedLetterArray = new ExtendedLetter[content.length];
		
		//If codes is null, create an array using the first constructor with 1 parameter
		if (codes == null) {
			
			for (int i = 0; i < content.length; i ++) {
				extendedLetterArray[i] = new ExtendedLetter(content[i]);
			}
		}
		//Otherwise create an array using the second constructor with 2 parameters
		else {
			for (int i = 0; i < content.length; i ++) {
				extendedLetterArray[i] = new ExtendedLetter(content[i], codes[i]);
			}
		}

		return extendedLetterArray;

	}
		
}
