package de.hsw.jee.guestbook01.services;

import de.hsw.jee.guestbook01.presentation.GuestbookServlet;

public class Services {

	private static UserService userService = null;
	private static GuestbookService guestbookService = null;
	
	public static UserService getUserService() {
		if(null == userService) {
			userService = new UserServiceMock();
		}
		return userService;
	}

	public static GuestbookService getGuestbookService() {
		if(null == guestbookService) {
			guestbookService = new GuestbookServiceMock();
		}
		return guestbookService;
	}

}
