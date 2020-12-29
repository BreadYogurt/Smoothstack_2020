/**
 * 
 */
package com.smoothstack.lms.cli;

import java.util.ArrayList;
import java.util.List;

import com.smoothstack.lms.cli.utils.Choice;
import com.smoothstack.lms.cli.utils.Utils;

/**
 * @author Brent Yurek
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Choice> choices = new ArrayList<>();
		choices.add(new LibrarianChoice());
		choices.add(new AdministratorChoice());
		choices.add(new BorrowerChoice());
		
		while (true) {
			System.out.println("Welcome to the SS Library Management System. Which category of a user are you?\n");
			Utils.createMenu(choices).run();
		}
	}

}
