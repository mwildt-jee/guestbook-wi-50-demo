package de.hsw.jee.guestbook01;

import java.util.List;

public interface GuestbookService {

	List<GuestbookEntry> getAll();
	
	GuestbookEntry insert(
			String username,
			String title,
			String message);
	
	
}
