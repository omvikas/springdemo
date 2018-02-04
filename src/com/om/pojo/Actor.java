package com.om.pojo;

import java.util.Date;

public class Actor {

	private int actorId;
	private String firstName;
	private String lastName;
	private Date updateDtm;
	
	public Actor() {
		
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getUpdateDtm() {
		return updateDtm;
	}

	public void setUpdateDtm(Date updateDtm) {
		this.updateDtm = updateDtm;
	}
	
}
