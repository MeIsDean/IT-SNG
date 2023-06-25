package de.hws.data;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private long cid;
	private String name;
	private String vorname;
	private String adresse;
	
	public Customer(long cid, String name, String vorname, String adresse) {
		super();
		this.cid = cid;
		this.name = name;
		this.vorname = vorname;
		this.adresse = adresse;
		
		
	}

	public long getCId() {
		return cid;
	}
	
	public String getName() {
		return name;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String toString() {
		return null;
	}
	
	public String[] getCustomerData() {
		return null;
	}
	
	public String[] getCustomerColumns() {
		return null;
	}
}
