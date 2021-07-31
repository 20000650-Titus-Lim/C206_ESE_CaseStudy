package ExrionsLibrary;

/**
* Validator helps to ensure entered data is valid, such as preventing empty String entries and negative integers when it should be positive
* Personal property of Titus Lim (Exrion)
*
* @author  Titus Lim
* @version 1.1
* @since   2021-05-17
*/

public class Validator {
	/**
	* Validates that the String entered is not null or empty.
	* @param msg : A message to send to console output for the user to enter a value
	* @return Returns the value that the user entered.
	*/
	public static String readString(String msg) {
		String inputMsg = Helper.readString(msg);
		while(inputMsg.length() <= 0 || (inputMsg.equalsIgnoreCase("null"))) {
			System.out.println("Invalid value, please re-enter");
			inputMsg = Helper.readString(msg);			
		}
		return inputMsg;
	}
	
	/**
	* Validates that the integer entered is positive (including 0)
	* @param msg : A message to send to console output for the user to enter a value
	* @return Returns the value that the user entered.
	*/
	public static int readIntPos(String msg) {
		int inputMsg = Helper.readInt(msg);
		while(inputMsg < 0) {
			System.out.println("Invalid value, please re-enter");
			inputMsg = Helper.readInt(msg);			
		}
		return inputMsg;
	}
	
	/**
	* Validates that the integer entered is negative (including 0)
	* @param msg : A message to send to console output for the user to enter a value
	* @return Returns the value that the user entered.
	*/
	public static int readIntNeg(String msg) {
		int inputMsg = Helper.readInt(msg);
		while(inputMsg > 0) {
			System.out.println("Invalid value, please re-enter");
			inputMsg = Helper.readInt(msg);			
		}
		return inputMsg;
	}
	
	/**
	* Validates that the double entered is positive (including 0)
	* @param msg : A message to send to console output for the user to enter a value
	* @return Returns the value that the user entered.
	*/
	public static double readDoublePos(String msg) {
		double inputMsg = Helper.readDouble(msg);
		while(inputMsg < 0) {
			System.out.println("Invalid value, please re-enter");
			inputMsg = Helper.readDouble(msg);			
		}
		return inputMsg;
	}
	
	/**
	* Validates that the double entered is negative (including 0)
	* @param msg : A message to send to console output for the user to enter a value
	* @return Returns the value that the user entered.
	*/
	public static double readDoubleNeg(String msg) {
		double inputMsg = Helper.readDouble(msg);
		while(inputMsg > 0) {
			System.out.println("Invalid value, please re-enter");
			inputMsg = Helper.readDouble(msg);			
		}
		return inputMsg;
	}
	
	/**
	* Validates that the char entered is not empty.
	* @param msg : A message to send to console output for the user to enter a value
	* @return Returns the value that the user entered.
	*/
	public static char readChar(String msg) {
		char inputMsg = Helper.readChar(msg);
		while(inputMsg <= 0) {
			System.out.println("Invalid value, please re-enter");
			inputMsg = Helper.readChar(msg);			
		}
		return inputMsg;
	}
	
	/**
	* Validates that the char entered is either 'm' or 'f' (case insensitive)
	* @param msg : A message to send to console output for the user to enter a value
	* @return Returns the value that the user entered.
	*/
	public static char readCharGender(String msg) {
		char inputMsg = Helper.readChar(msg);
		while(!(inputMsg == 'M' || inputMsg == 'm' || inputMsg == 'F' || inputMsg == 'f')) {
			System.out.println("Invalid value, please re-enter");
			inputMsg = Helper.readChar(msg);			
		}
		return inputMsg;
	}
}
