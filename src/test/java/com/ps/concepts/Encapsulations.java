package com.ps.concepts;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Encapsulations 
{
	private String name;
	private int id;
	
	public void setName(String myname )
	{
		name=myname;
	}
public void setId(int newid)
{
id=newid;
}
public String getName()
{
	return name;
			}

public int getid()
{
return id;	
}
	public static void main(String[] args) 
	{		
		Encapsulations enc= new Encapsulations();
		enc.setName("Manjunath");
		enc.setId(2345);
		
		System.out.println("Employer Name " + enc.getName() + "   " + enc.getid());

	}

}
