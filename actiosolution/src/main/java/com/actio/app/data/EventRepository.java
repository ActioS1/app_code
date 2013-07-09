package com.actio.app.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.actio.app.model.Event;


	@ApplicationScoped
	public class EventRepository {

	    @Inject
	    private EntityManager em;

	    public Event findById(Long id) {
	        return em.find(Event.class, id);
	    }

	    public List<Event> findAllOrderedByTitle() {
	        CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Event> criteria = cb.createQuery(Event.class);
	        Root<Event> event = criteria.from(Event.class);
	        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
	        // feature in JPA 2.0
	        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
	        criteria.select(event);//.orderBy(cb.asc(event.get("title")));
	        return em.createQuery(criteria).getResultList();
	    }
	 }