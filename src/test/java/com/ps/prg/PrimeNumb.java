package com.ps.prg;

public class PrimeNumb {

	public static void main(String[] args) {

		int res, numb=14;
		boolean flag= true;
		
		for (int i=2; i<=numb; i++)
		{
			res=numb%i;
			if (res==0)
			{
				flag=true;
				break;
			}
		}
			if(flag)
			{
				System.out.println("It is a Prime Number");
			}
			else
			{
				System.out.println("It is Not a Prime Number");
			}
			
		}
}
