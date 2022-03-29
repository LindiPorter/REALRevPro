package com.revature.project0.entities;

public class AccountEntities {

	private String account;
	private int balance;
	private int id;
	private int cid; 
	
	//Getters and Setters
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	// Default Constructor
	public AccountEntities() {
		super();
	}
	
	// Parameterized Constructor

	@Override
	public String toString() {
		return "AccountEntities [account=" + account + ", balance=" + balance + ", id=" + id + ", cid=" + cid + "]";
	}
	public AccountEntities(String account, int balance, int id, int cid) {
		super();
		this.account = account;
		this.balance = balance;
		this.id = id;
		this.cid = cid;
	}

	
	
	
	
	
	


	
	
	
}
	
	
	
	