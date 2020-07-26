package com.desginpattern.singleton;

public final class Singleton {

	private static int counter=0;
	
	/*step2: declare a static private variable which returns the instance state of the object-Shraddha chutiya hais*/
	private static Singleton instance=null;
	
	/*step1 : let us make this constructor private. 
	so that class cannot be instantiated from outside*/
	//public Singleton()
	private Singleton()
	{
		counter++;
		System.out.println("counter value "+counter);
	}
	
	/*step 3: Write a static method which will return the new instance of the
	 *  class only if it is not already instantiated*/
	public static Singleton getInstance()
	{
		if(instance == null)
			instance = new Singleton();
		
		return instance;
	}
	
	
	public  void displayMessage(String message)
	{
		System.out.println("Hello there " +message );
		
	}
}


