package com.revature.project0.entities;

public class ClientsEntities {

	// Variables
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ClientsEntities(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public ClientsEntities() {
		super();
	}
	@Override
	public String toString() {
		return "ClientsEntities [id=" + id + ", name=" + name + "]";
	}

}
