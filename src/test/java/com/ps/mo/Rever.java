package com.ps.mo;

public class Rever {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String orgi="MALAYALam";
		String rev="";
		int count=orgi.length();
		
		for (int i=count-1;i>=0; i--)
		{
			rev=rev+orgi.charAt(i);
			
		}
		System.out.println(rev);
		
		if (rev.equalsIgnoreCase(orgi))
		{
		System.out.println("Palnedromer");	
		}
		else
		{
			System.out.println("not a palendrome");
		}
	}

}
