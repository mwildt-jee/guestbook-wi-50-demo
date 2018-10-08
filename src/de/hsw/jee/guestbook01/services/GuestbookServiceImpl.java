package de.hsw.jee.guestbook01.services;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.hsw.jee.guestbook01.model.GuestbookEntry;
import de.hsw.jee.guestbook01.model.User;

@Stateless
public class GuestbookServiceImpl implements GuestbookService {
	
	@PersistenceContext 
	private EntityManager entityManager;
	
	public List<GuestbookEntry> getAll() {
		return entityManager.createQuery("select g from GuestbookEntry g", GuestbookEntry.class).getResultList();
	}
	
	public GuestbookEntry insert(User user,String title,String message) {
		GuestbookEntry e = new GuestbookEntry(user, title, message);
		this.entityManager.persist(e);
		return e;
	}
	
}
