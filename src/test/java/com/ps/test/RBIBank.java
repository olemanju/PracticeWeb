package com.ps.test;

abstract class RBIBank
{

	public RBIBank() {
		System.out.println("I am RBI Const");
	}
	
	void display()
	{
		System.out.println("I am having both concrete and abstract Methods");
	}
	
	abstract int getRateOfInterrest();
	
}
