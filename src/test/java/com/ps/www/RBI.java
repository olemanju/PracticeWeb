package com.ps.www;

public abstract class RBI
{

	String name="manjunath";
	
	public RBI() {
		System.out.println("I am Constructor of RBI");
	}
	
	public void displayname()
	{
		System.out.println("My Name is abstract ");
	}
	
	   abstract int RateOfInterest();
}
