package com.ps.concepts;

public class RevInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numb=123456;
		int reve=0;
		
	while(numb!=0)
	{
		reve=reve*10;
		reve=reve+numb%10;
		numb=numb/10;
	}
		System.out.println(reve);

	}

}
