package com.actio.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ao_issue_statuses database table.
 * 
 */
@Entity
@Table(name="ao_issue_statuses")
@NamedQuery(name="IssueStatus.findAll", query="SELECT i FROM IssueStatus i")
public class IssueStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="class")
	private String cssClass;

	private String title;

	//bi-directional many-to-one association to Event
	//@OneToMany(mappedBy="issueStatus")
	//private List<Event> events;

	public IssueStatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCssClass() {
		return this.cssClass;
	}

	public void setCssClass(String ccsClass) {
		this.cssClass = ccsClass;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
/*
	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setIssueStatus(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setIssueStatus(null);

		return event;
	}
*/
}