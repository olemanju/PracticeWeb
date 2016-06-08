package com.ps.stringfunctions;

public class StrExaples 

{
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name="Manjunath Ramaswamy";
		
		System.out.println(name);
		
		System.out.println(name.charAt(5));//n
		
		System.out.println(name.length());//19
		System.out.println(name.indexOf('a'));//1
		System.out.println(name.lastIndexOf('a'));//16
		System.out.println(name.lastIndexOf("Ramaswamy"));//10
		
		
		String s1="Java is a programming language. Java is a platform. Java is an Island.";
		
		String replace= s1.replace('a', 'z');
		System.out.println(replace);//Jzvz is z progrzmming lznguzge. Jzvz is z plztform. Jzvz is zn Islznd.
		
		String replace1= s1.replace("java", "manju");
		System.out.println("manju");
		
		String str1 = "String method tutorial";
	       String str2 = "compareTo method example";
	       
	       if (str1.equalsIgnoreCase(str2)) 
	       {
			System.out.println("Bothe the Strings are equal");
		}
	       else
	       {
	    	   System.out.println("Not Equal");
	       }
	       
	       
	       String str11 = new String("This is a test String");
	       String str21 = new String("Test ABC");
	       boolean var1 = str11.endsWith("String");
	       boolean var2 = str11.endsWith("ABC");
	       boolean var3 = str21.endsWith("String");
	       boolean var4 = str21.endsWith("ABC");

	       System.out.println(str11.endsWith("manju"));//false
	       System.out.println(str21.endsWith("ABC"));//true
		
	       
	       
	       String str10 = new String("This is a BeginnersBook tutorial");
	       String str20 = new String("Beginners");
	       String str30 = new String("Book");
	       String str40 = new String("Books");
	       
	       System.out.println("Index of B in str1: "+str10.indexOf('B'));
	       System.out.println("Index of B in str1 after 15th char:"+str10.indexOf('B', 15));
	       System.out.println("Index of B in str1 after 30th char:"+str10.indexOf('B', 30));
	       System.out.println("Manju");
	       System.out.println("Index of string str2 in str1:"+str10.indexOf(str20));
	       System.out.println("Index of str2 after 15th char"+str10.indexOf(str20, 15));
	       
	       System.out.println("Index of string str3:"+str10.indexOf(str30));
	       System.out.println("Index of string str4"+str10.indexOf(str40));
	       System.out.println("Index of harcoded string:"+str10.indexOf("is"));
	       System.out.println("Index of hardcoded string after 4th char:"+str10.indexOf("is", 4));

	       String fogname="quick brown fox jumps over the lazy dog";
	       System.out.println(fogname.substring(5));//brown fox jumps over the lazy dog
	       System.out.println(fogname.substring(6, 11));//brown
	       
	       
	       String strr= "28/12/2013";
	       
	       String arr1[]= strr.split("/");

	       for (String splt : arr1)
	       {
	    	   System.out.println(splt);
	       }
	       
	       
	       String arr2[]=strr.split("/",2);
	       
	       for (String splt1 : arr2)
	       {
	    	   System.out.println(splt1);
	}
	}
}
