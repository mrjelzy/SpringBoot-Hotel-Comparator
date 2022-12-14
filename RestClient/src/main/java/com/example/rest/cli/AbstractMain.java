package com.example.rest.cli;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class AbstractMain {
	
	public static String SERVICE_AGENCY_URL;
	public static final String QUIT = "0";
	protected void setTestServiceUrl(BufferedReader inputReader)
			throws IOException {
		
		System.out.println("Saisir l'URL de l'agence à laquel vous voulez vous connecter : ");
		SERVICE_AGENCY_URL = inputReader.readLine();
		
		/*while(!validServiceUrl()) {
			System.err.println("Error: "+SERVICE_AGENCY_URL+
					" isn't a valid web service URL. "
					+ "Please try again: ");
			SERVICE_AGENCY_URL = inputReader.readLine();
		}*/
	}
	
	
	protected abstract boolean validServiceUrl();
	
	
	protected abstract void menu();

}
