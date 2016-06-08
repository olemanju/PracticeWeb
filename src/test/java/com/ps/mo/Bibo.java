package com.ps.mo;

public class Bibo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n1=0,n2=1,n3,num=10;
		
		System.out.println(n1+ " " +n2);
		
		for (int i = 2; i < num; ++i) 
		{
			n3=n1+n2;
			System.out.println(n3);
			n1=n2;
			n2=n3;
			
		}

	}

}
