/**
 * 
 */
package com.smoothstack.lms.cli.adminchoices;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.lms.beans.Bean;
import com.smoothstack.lms.cli.utils.Choice;
import com.smoothstack.lms.cli.utils.QuitException;
import com.smoothstack.lms.cli.utils.Utils;
import com.smoothstack.lms.daos.BaseDAO;

/**
 * @author Brent Yurek
 *
 */
public abstract class AdminChoice<T extends Bean> extends Choice {
	BaseDAO<T> dao;
	
	public AdminChoice(BaseDAO<T> dao) {
		this.dao = dao;
	}
	
	@Override
	public void run() {
		boolean quit = false;
		List<Choice> choices = new ArrayList<>();
		choices.add(new AddChoice());
		choices.add(new UpdateChoice());
		choices.add(new DeleteChoice());
		choices.add(new ReadChoice());
		
		while (!quit) {
			try {
				Utils.createMenu(choices, "Quit to previous").run();
			} catch (QuitException e) {
				quit = true;
			}
		}
	}
	
	@Override
	public String getName() {
		return "Add/Update/Delete/Read " + getObjectPlural();
	}
	
	abstract String getObjectPlural();
	abstract String getObjectSingular();
	
	/*
	 * Prompts the user with questions to create an instance of a T
	 */
	abstract T creationPrompt() throws QuitException;
	
	/*
	 * Prompts the user with questions to update an instance of a T
	 */
	abstract T updatePrompt(T t) throws QuitException;
	
	class AddChoice extends Choice {
		@Override
		public void run() {
			try {
				T t = creationPrompt();
				dao.add(t);
			} catch (QuitException e) {
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		@Override
		public String getName() {
			return "Add a " + getObjectSingular();
		}
	}
	
	class UpdateChoice extends Choice {
		@Override
		public void run() {
			try {
				System.out.println("Select a " + getObjectSingular() + " to update.");
				T t = Utils.createMenu(dao.getAll(), "Quit to cancel operation");
				t = updatePrompt(t);
				dao.update(t);
			} catch (QuitException e) {
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public String getName() {
			return "Update a " + getObjectSingular();
		}
	}
	
	class DeleteChoice extends Choice {
		@Override
		public void run() {
			try {
				System.out.println("Select a " + getObjectSingular() + " to delete.");
				T t = Utils.createMenu(dao.getAll(), "Quit to cancel operation");
				dao.delete(t);
			} catch (QuitException e) {
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public String getName() {
			return "Delete a " + getObjectSingular();
		}
	}
	
	class ReadChoice extends Choice {

		@Override
		public void run() {
			try {
				System.out.println("Select a " + getObjectSingular() + " to read.");
				T t = Utils.createMenu(dao.getAll(), "Quit to cancel operation");
				t.printDetails();
				System.out.println();
			} catch (QuitException e) {
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public String getName() {
			return "Read a " + getObjectSingular();
		}
		
	}
}