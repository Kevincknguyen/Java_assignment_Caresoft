package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {

	

	@Override
	public boolean assignPin(int pin) {
		
		if (Integer.toString(pin).length()==6) {
			System.out.println("Accepted. Your pin is: "+pin);
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID.equals(this.getId())) {
			return true;
		}
		else {
			newIncident("Authorization denied for entry. User inputted: "+Integer.toString(confirmedAuthID));
			return false;
		}
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		
		return this.getSecurityIncidents();
	}
	
    
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    public AdminUser(Integer employeeID, String role) {
    	super(employeeID);
		this.employeeID=employeeID;
		this.role=role;
		this.securityIncidents= new ArrayList<String>();
		
	}
    
    


	public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
  		
}
