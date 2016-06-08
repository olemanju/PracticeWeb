package com.ps.poly;

public class StPoly {
	
int sum(int x, int y)
{
	return x+y;
}

int sum(int x, int y, int z)
{
	
return x+y+z;
		}

int sum(int x, double y)
{
return x+(int)y;	
}

	public static void main(String[] args) 
	{
	StPoly sp= new StPoly();
	System.out.println(sp.sum(10, 20));
	System.out.println(sp.sum(12, 22.5));
	System.out.println(sp.sum(3, 3, 2));
		
		

	}

}
