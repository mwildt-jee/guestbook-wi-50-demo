package de.hsw.jee.guestbook01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuestbookServiceMock implements GuestbookService{

	private List<GuestbookEntry> liste = new ArrayList<>(Arrays.asList(
		new GuestbookEntry("Malte", "Hallo", "Hallo Leute"),
		new GuestbookEntry("Klaus", "Zurück", "....")
	));
	
	@Override
	public List<GuestbookEntry> getAll() {
		return liste;
	}

	@Override
	public GuestbookEntry insert(String username, String title, String message) {
		GuestbookEntry eintrag = new GuestbookEntry(username, title, message);
		liste.add(eintrag);
		return eintrag;
	}

}
