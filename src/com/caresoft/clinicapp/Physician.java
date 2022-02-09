package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {	

	@Override
	public boolean assignPin(int pin) {
		if (Integer.toString(pin).length()==4) {
			this.setPin(pin);
			System.out.println("Accepted. Your pin is: "+pin);
			return true;
		}
		else {
		return false;
		}
	}


	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
//		System.out.println("Input id"+confirmedAuthID);
//		System.out.println("What the actual id is"+Integer.toString(this.getId()));
		if (confirmedAuthID.equals(this.getId())) {
			return true;
		}
		else {
			
			return false;
		}
	}
    
    
    private ArrayList<String> patientNotes;
    
    public Physician(Integer id) {
		super(id);
		this.patientNotes= new ArrayList<String>();
	}
	
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}


	
}
