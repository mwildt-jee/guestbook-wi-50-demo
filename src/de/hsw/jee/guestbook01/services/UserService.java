package de.hsw.jee.guestbook01.services;

import java.util.Optional;

import javax.ejb.Local;

import de.hsw.jee.guestbook01.model.User;

@Local
public interface UserService {

	Optional<User> findByUsername(String username);

	boolean checkPassword(User user, String password);

	User register(String username, String password) throws UserException;

}
