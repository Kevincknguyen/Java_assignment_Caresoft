package com.caresoft.clinicapp;

public class Test {

	public static void main(String[] args) {
		System.out.println(Integer.toString(1000).length());
		
//		// .. Main method set up ... //
        Physician doctor10 = new Physician(1);
        System.out.println("ID: "+doctor10.getId());
        System.out.println("Pin: "+doctor10.getPin());
        System.out.println(doctor10.getPatientNotes());
        AdminUser roseTyler = new AdminUser(2, "Companion");
        System.out.println(roseTyler.getRole());
        System.out.println("ID: "+roseTyler.getId());
        System.out.println(roseTyler.getSecurityIncidents());
        AdminUser donnaNoble = new AdminUser(28, "Companion");
        System.out.println(donnaNoble.getRole());
        System.out.println("ID: "+donnaNoble.getId());
        System.out.println(donnaNoble.getSecurityIncidents());
//        
//        
//        // Physician Implementation Tests
        System.out.println("\n========== Physician Tests ==========\n");
        String pinTest1 = doctor10.assignPin(4200)? "PASS" : "FAIL";
        System.out.printf("Physician pin assign test 1: %s\n", pinTest1);
        
//        
        String pinTest2 = doctor10.assignPin(12)? "PASS" : "FAIL";
        System.out.printf("Physician pin assign test 2: %s\n", pinTest2);
       
//        
        String authTest1 = doctor10.accessAuthorized(1234)? "PASS" : "FAIL";
        System.out.printf("Physician auth test 1: %s\n", authTest1);
        
        String authTest2 = doctor10.accessAuthorized(1)? "PASS" : "FAIL";
        System.out.printf("Physician auth test 2: %s\n", authTest2);
//        
//        // AdminUser Implementation Tests
        System.out.println("\n========== AdminUser Tests ==========\n");
        String pinTest3 = roseTyler.assignPin(4212)? "PASS" : "FAIL";
        System.out.printf("Admin pin assign test 1: %s\n", pinTest3);
//        
        String pinTest4 = roseTyler.assignPin(424242)? "PASS" : "FAIL";
        System.out.printf("Admin pin assign test 2: %s\n", pinTest4);
        
        String authTest3 = roseTyler.accessAuthorized(1234)? "PASS" : "FAIL";
        System.out.printf("Admin auth test 1: %s\n", authTest3);
        
        String authTest4 = roseTyler.accessAuthorized(1234)? "PASS" : "FAIL";
        System.out.printf("Admin auth test 1: %s\n", authTest4);
        
        String authTest5 = roseTyler.accessAuthorized(2)? "PASS" : "FAIL";
        System.out.printf("Admin auth test 2: %s\n\n", authTest5);
//        
        donnaNoble.accessAuthorized(42);
        donnaNoble.accessAuthorized(4321);
        donnaNoble.accessAuthorized(7);
        donnaNoble.accessAuthorized(28);
//        
        System.out.println(donnaNoble.reportSecurityIncidents());

	}

}
