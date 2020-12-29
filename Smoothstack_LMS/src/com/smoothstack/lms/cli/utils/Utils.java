/**
 * 
 */
package com.smoothstack.lms.cli.utils;

import java.util.List;
import java.util.Scanner;

/**
 * @author Brent Yurek
 *
 */
public class Utils {
	public static <T> T createMenu(List<T> choices, String quitOption, String nullOption, T defaultChoice) throws QuitException {
		int count = 0, quitPos = 0, nullPos = 0, defPos = 0;
		for (T choice : choices) {
			System.out.println(++count + ") " + choice);
		}
		if (nullOption != null) {
			nullPos = ++count;
			System.out.println(nullPos + ") " + nullOption);
		}
		if (defaultChoice != null) {
			defPos = ++count;
			System.out.println(defPos + ") No Change (" + defaultChoice + ")");
		}
		if (quitOption != null) {
			quitPos = ++count;
			System.out.println(quitPos + ") " + quitOption);
		}
		System.out.println();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		try {
			while (true) {
				int i = input.nextInt();
				if ((i > 0) && (i <= count)) {
					if (i == quitPos) {
						throw new QuitException();
					} else if (i == nullPos) {
						return null;
					} else if (i == defPos) {
						return defaultChoice;
					} else {
						return choices.get(i - 1);
					}
				}
				System.out.println("Choice is not in range. Please try again.");
			}
		} finally {
			System.out.println();
		}
	}
	
	public static <T> T createMenu(List<T> choices, String quitOption, String nullOption) throws QuitException {
		return createMenu(choices, quitOption, nullOption, null);
	}
	
	public static <T> T createMenu(List<T> choices, String quitOption) throws QuitException {
		return createMenu(choices, quitOption, null);
	}
	
	public static <T> T createMenu(List<T> choices) {
		try {
			return createMenu(choices, null);
		} catch (QuitException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String stringPrompt(String prompt, boolean required) throws QuitException {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println(prompt +":");
			String resp = input.nextLine();
			if (resp.equals("quit")) {
				throw new QuitException();
			} else if (resp.equals("")) {
				if (required) {
					System.out.println("This field is required and cannot be left blank.");
				} else {
					return null;
				}
			} else {
				return resp;
			}
		}
	}
	
	public static String stringPrompt(String prompt) throws QuitException {
		return stringPrompt(prompt, false);
	}
	
	public static void printQuitNote() {
		System.out.println("Enter 'quit' at any prompt to cancel operation.");
	}
}
