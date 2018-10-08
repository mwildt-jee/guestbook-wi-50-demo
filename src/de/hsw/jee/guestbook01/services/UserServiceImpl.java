package de.hsw.jee.guestbook01.services;

import java.util.Objects;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.hsw.jee.guestbook01.model.User;

@Stateless
public class UserServiceImpl implements UserService {

	@PersistenceContext(unitName="guestbookPU")
	private EntityManager entityManager;
	
	@Override
	public User register(String username, String password) throws UserException {
		final User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		if (this.findByUsername(username).isPresent()) {
			throw UserException.userAlreadyExists(username);
		}
		entityManager.persist(user);
		return user;
	}
	
	@Override
	public Optional<User> findByUsername(String username) {
		
		TypedQuery<User> query = entityManager.createQuery("select u from User u where u.username = :username", User.class);
		query.setParameter("username", username);
		try {
			return Optional.of(query.getSingleResult());
		} catch (NonUniqueResultException e) {
			throw new RuntimeException("Keine eindeutige ergebnis", e);
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

	@Override
	public boolean checkPassword(User user, String password) {
		return Objects.equals(user.getPassword(), password);
	}
	
}
