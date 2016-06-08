package com.ps.www;

public class Encapsule {
	
	private String name;
	
	public void setName( String fname)
	{
		name=fname;
	}

	public String getName()
	{
		return name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Encapsule en= new Encapsule();
		en.setName("manjunath");
		System.out.println(en.getName());

	}

}
