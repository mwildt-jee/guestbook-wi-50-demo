package de.hsw.jee.guestbook01;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import de.hsw.jee.guestbook01.model.User;
import de.hsw.jee.guestbook01.services.GuestbookService;
import de.hsw.jee.guestbook01.services.Services;
import de.hsw.jee.guestbook01.services.UserException;
import de.hsw.jee.guestbook01.services.UserService;

@WebListener
public class ApplicationContextListener implements ServletContextListener {
	
	private final UserService userService = Services.getUserService();
	private final GuestbookService guestbookService = Services.getGuestbookService();
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			User admin = userService.register("admin", "admin");
			User user = userService.register("user", "user");
			guestbookService.insert(admin, "Der erste Eintrag", "Hallo Leute! Ich bins, der Admin");
			guestbookService.insert(user, "Gruß", "Auch der user wünsch alle Gute.");
		} catch (UserException e) {
			throw new RuntimeException(e);
		}
	}

}
