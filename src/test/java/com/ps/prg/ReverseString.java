package com.ps.prg;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="sandy";
		String reve="";
		
int count= name.length();

for (int i=count-1; i>=0; i--)
{
	
reve= reve+name.charAt(i);
}

System.out.println(reve);

if (reve.equalsIgnoreCase(name))
{
System.out.println("Palendrome");	
}
else
{
System.out.println("Not a Palendrome");	
}
	}

}
