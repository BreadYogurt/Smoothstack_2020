/**
 * 
 */
package com.smoothstack.lms.cli.adminchoices;

import com.smoothstack.lms.beans.Publisher;
import com.smoothstack.lms.cli.utils.QuitException;
import com.smoothstack.lms.cli.utils.Utils;
import com.smoothstack.lms.daos.BaseDAO;

/**
 * @author Brent Yurek
 *
 */
public class PublisherAdminChoice extends AdminChoice<Publisher> {

	public PublisherAdminChoice(BaseDAO<Publisher> dao) {
		super(dao);
	}

	@Override
	String getObjectPlural() {
		return "Publishers";
	}

	@Override
	String getObjectSingular() {
		return "Publisher";
	}

	@Override
	Publisher creationPrompt() throws QuitException {
		Publisher publisher = new Publisher();
		Utils.printQuitNote();
		publisher.setName(Utils.stringPrompt("Please enter publisher name", true));
		publisher.setAddress(Utils.stringPrompt("Please enter publisher address"));
		publisher.setPhone(Utils.stringPrompt("Please enter publisher phone number"));
		return publisher;
	}

	@Override
	Publisher updatePrompt(Publisher publisher) throws QuitException {
		Utils.printQuitNote();
		
		String publisherName = Utils.stringPrompt("Please enter new publisher name or enter N/A for no change", true);
		if (!"N/A".equals(publisherName)) {
			publisher.setName(publisherName);
		}
		
		String publisherAddress = Utils.stringPrompt("Please enter new publisher address or enter N/A for no change");
		if (!"N/A".equals(publisherAddress)) {
			publisher.setAddress(publisherAddress);
		}
		
		String publisherPhone = Utils.stringPrompt("Please enter new publisher phone number or enter N/A for no change");
		if (!"N/A".equals(publisherPhone)) {
			publisher.setPhone(publisherPhone);
		}
		
		return publisher;
	}
	
}