package com.ps.abs;

public class MainMet 
{
	
	public static void main(String args[])
	{
		CITI cc= new CITI();
		SHI ss= new SHI();
		System.out.println(cc.getRateOfInterest());
		System.out.println(ss.getRateOfInterest());
		cc.display();
		ss.display();
		
	}

}
