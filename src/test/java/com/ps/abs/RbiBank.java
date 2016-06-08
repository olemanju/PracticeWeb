package com.ps.abs;

public abstract class RbiBank 
{

	public RbiBank()
	{
		System.out.println("I am RBI Constru");
	}
	public void display()
	{
		System.out.println("I am Having method and abstract method");
	}
	
 abstract int getRateOfInterest();
	
}
