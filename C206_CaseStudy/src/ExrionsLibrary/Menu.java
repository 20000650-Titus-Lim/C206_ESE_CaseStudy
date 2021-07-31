package ExrionsLibrary;

import java.util.ArrayList;

/**
* Menu helps to create menu driven programmes easily without typing it out all the time. 
* Personal property of Titus Lim (Exrion)
*
* @author  Titus Lim
* @version 1.1
* @since   2021-05-17
*/

public class Menu {	
	private static ArrayList<String> optionList = new ArrayList<String>();
	
	/**
	* Prints a menu
	* @param menu : An ArrayList, preferably from MenuObjects that holds the Strings to be printed
	* @param title : The main title of the menu
	*/
	public void printMenu(String title) {
		printTitle(title);
		for(int i = 0; i < optionList.size(); i++) {
			System.out.printf("%d. %s\n", i + 1, optionList.get(i));
		}
		Helper.line(40, "-");
	}
	
	/**
	* Prints a title
	* @param title : The title of this menu
	*/
	public static void printTitle(String title) {
		Helper.line(40, "=");
		System.out.println(title);
		Helper.line(40, "=");
	}
	
	/**
	* Adds an option to the stored ArrayList
	* @param option : String value to be stored in the ArrayList
	*/
	public void addOption(String option) {
		optionList.add(new String(option));
	}

	/**
	* Returns the stored ArrayList
	*/
	public ArrayList<String> getOptionList() {
		return optionList;
	}
}
