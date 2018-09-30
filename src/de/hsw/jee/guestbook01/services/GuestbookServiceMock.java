package de.hsw.jee.guestbook01.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.hsw.jee.guestbook01.model.GuestbookEntry;
import de.hsw.jee.guestbook01.model.User;

public class GuestbookServiceMock implements GuestbookService{

	private List<GuestbookEntry> liste = new ArrayList<>();
	
	@Override
	public List<GuestbookEntry> getAll() {
		return liste;
	}

	@Override
	public GuestbookEntry insert(User user, String title, String message) {
		GuestbookEntry eintrag = new GuestbookEntry(user, title, message);
		liste.add(eintrag);
		return eintrag;
	}

}
