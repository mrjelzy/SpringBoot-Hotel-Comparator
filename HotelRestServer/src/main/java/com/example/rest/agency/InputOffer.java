package com.example.rest.agency;

import java.time.LocalDate;

public class InputOffer {
	private String aName;
	private String aPassword;
	LocalDate start;
	LocalDate end;
	int nbPeoples;
	
	public InputOffer() {}

	public InputOffer(String aName, String aPassword, LocalDate start, LocalDate end, int nbPeoples) {
		super();
		this.aName = aName;
		this.aPassword = aPassword;
		this.start = start;
		this.end = end;
		this.nbPeoples = nbPeoples;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaPassword() {
		return aPassword;
	}

	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public int getNbPeoples() {
		return nbPeoples;
	}

	public void setNbPeoples(int nbPeoples) {
		this.nbPeoples = nbPeoples;
	}
	
}
