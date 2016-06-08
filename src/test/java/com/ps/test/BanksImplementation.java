package com.ps.test;

public class BanksImplementation 
{

	public static void main(String[] args) {
	
		CanaraBank cb= new  CanaraBank();
		YesBank yb= new YesBank();
		cb.display();
		System.out.println(cb.getRateOfInterrest());
		yb.display();
		System.out.println(yb.getRateOfInterrest());
		yb.getRateOfInterrest();

	}

}
