/**
 * 
 */
package com.smoothstack.assignments.day3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author Brent Yurek
 *
 * Takes first argument as a directory (or prompts for one if none given) and lists everything in the directory.
 */
public class ListDir {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Path dir;
		if (args.length > 0) {
			dir = Paths.get(args[0]);
		} else {
			try (Scanner input = new Scanner(System.in)){
				System.out.print("Directory to list contents of: ");
				String p = input.nextLine();
				dir = Paths.get(p);
			}
		}
		
		try (DirectoryStream<Path> contents = Files.newDirectoryStream(dir)){
			for (Path item : contents) {
				System.out.println(item.getFileName());
			}
		} catch (IOException e) {
			System.out.println("ERROR: Not a valid directory.");
		}
	}

}
