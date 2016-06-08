package com.ps.www;

public class BankDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ICICI ic= new ICICI();
	System.out.println(ic.RateOfInterest());
	System.out.println(ic.name);
	ic.displayname();
	
	Canfin an= new Canfin();
	System.out.println(an.RateOfInterest());
	System.out.println(an.name);
	an.displayname();
	
	

	}

}
