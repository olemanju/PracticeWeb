package com.ps.prg;

public class Prime100 {

	public static void main(String[] args) {
	
		int numb=100;
		int res;
		boolean flag=true;
		
		for(int i=2; i<=numb/2;i++)
		{
			res=numb%i;
			if(res==0)
			{
				flag=false;
				break;
			}
		
		if(flag=false)
		{
			System.out.println("Prime NUmbers " + res);
		}
		}
		}
	}

