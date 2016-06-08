package com.ps.prg;

public class Encap {

	
	private String name;
	private int id;
			
			public void setName(String myName)
			{
				name=myName;
			}
			public void setId(int empId)
			{
				id=empId;
			}
			
			public String getName()
			{
				return name;
			}
			
			public int getId()
			{
				return id;
			}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Encap en= new Encap();
		en.setName("Manjunath");
		en.setId(2356);
		System.out.println(en.getId() + " "+ en.getName()) ;

	}

}
