package com.actio.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ao_events database table.
 * 
 */
@Entity
@Table(name="ao_events")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	private String title;

	//bi-directional many-to-one association to IssueStatus
	@ManyToOne
	@JoinColumn(name="status_id")
	private IssueStatus issueStatus;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="assigned_to_id")
	private User user;

	public Event() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public IssueStatus getIssueStatus() {
		return this.issueStatus;
	}

	public void setIssueStatus(IssueStatus issueStatus) {
		this.issueStatus = issueStatus;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}