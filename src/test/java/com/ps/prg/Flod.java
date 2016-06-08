package com.ps.prg;

public class Flod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i, j, numb=1, rows=10;
		
		for(i=1; i<=rows; i++)
		{
			for(j=1;j<=i; j++)
			{
				System.out.print(numb + "  ");
				numb++;
			}
			System.out.println();
		}

	}

}
