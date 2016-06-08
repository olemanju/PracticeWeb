package com.ps.mo;

public class ReverseInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number=123456;
		int rever=0;
		
		while(number!=0)
		{
			rever= rever*10;
			rever=rever+number%10;
			number=number/10;
		
		}
		
System.out.println(rever);
	}

}
