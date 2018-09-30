package de.hsw.jee.guestbook01.services;

import java.util.List;

import de.hsw.jee.guestbook01.model.GuestbookEntry;
import de.hsw.jee.guestbook01.model.User;

public interface GuestbookService {

	List<GuestbookEntry> getAll();
	
	GuestbookEntry insert(
			User user,
			String title,
			String message);
	
	
}
