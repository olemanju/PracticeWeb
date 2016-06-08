package com.ps.concepts;

public class ReverseString {

	public static void main(String[] args) {

String name="Rotavator";
String rev="";
int strlength=name.length();

for (int i =strlength-1; i >=0; i--)
{
	rev= rev+name.charAt(i);
}
System.out.println(rev);
	}

}
