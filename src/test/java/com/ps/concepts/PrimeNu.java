package com.ps.concepts;

public class PrimeNu {

	public static void main(String[] args) 
		{
		
int n=7, res;
boolean  flag=true;

for (int i =2; i<=n/2; i++)
{
	res=n%i;
	if(res==0)
	{
		flag=false;
		break;
	}
	}
if (flag) 
{
	System.out.println(n + " Is prime NUmber");
}
else
{
System.out.println(n +" Is not a Prime");	
}
	}
}
