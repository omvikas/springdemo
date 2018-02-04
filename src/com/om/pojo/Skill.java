package com.om.pojo;



public class Skill {

	private int skid;
	private String name;
	private String type;
	private Student student;
	public int getSkid() {
		return skid;
	}
	public void setSkid(int skid) {
		this.skid = skid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Skill( String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	
}
