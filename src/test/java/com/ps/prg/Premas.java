package com.ps.prg;

public class Premas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=13;
		int res;
		boolean flag=true;
		
		for(int i=2; i<=n/2; i++)
		{
			res=n%i;
			if (res==0)
			{
				flag=false;
				break;
			}}
			if(flag=true)
			{
				System.out.println("Prime");
			}
			else
			{
				System.out.println("Not a  Prime");
			}
		
			

	}

}
