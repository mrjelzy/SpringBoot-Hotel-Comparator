package com.example.rest.comparator;

import java.time.LocalDate;

public class OutputSearch {
	
	private String login;
	private String password;
	LocalDate start;
	LocalDate end;
	int nbPeoples;
	
	public OutputSearch() {}

	public OutputSearch(String login, String password, LocalDate start, LocalDate end, int nbPeoples) {
		this.login = login;
		this.password = password;
		this.start = start;
		this.end = end;
		this.nbPeoples = nbPeoples;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
