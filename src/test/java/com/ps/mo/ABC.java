package com.ps.mo;

public class ABC extends XYZ
{

	public void display()
	{
		System.out.println("I am child class");
	}
	
	public void contact()
	{
		System.out.println("Child contact");
	}
	public static void main(String[] args) 
	{


ABC ab= new ABC();
ab.display();
ab.contact();
ab.showme();
	}

}
