package com.ps.prg;

public class NewPrime {
	
	public boolean primeme(int number)
	{
		for(int i=2; i<=number/2; i++)
		{
			if(number%i==0)
			{
				return false;
			}
		}
			
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NewPrime np= new NewPrime();
		System.out.println(np.primeme(17));
	}

}
