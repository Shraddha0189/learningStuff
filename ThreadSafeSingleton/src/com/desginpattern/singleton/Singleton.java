package com.desginpattern.singleton;

public final class Singleton {

	private static int counter=0;
	
	/*step2: declare a static private variable which returns the instance state of the object*/
	private static volatile Singleton instance=null;
	
	/*step1 : let us make this constructor private. 
	so that class cannot be instantiated from outside*/
	//public Singleton()
	private Singleton()
	{
		counter++;
		System.out.println("counter value "+counter);
		System.out.println("instance created");
	}
	
	/*step 3: Write a static method which will return the new instance of the
	 *  class only if it is not already instantiated*/
	//public static synchronized Singleton getInstance()
	public static Singleton getInstance()		//Double check locking
	{
		
		if(instance == null) {		//Single checked
			synchronized(Singleton.class) {
		if(instance == null)		//Double checked
			instance = new Singleton();
			}
		}
		return instance;
	}
	
	public  void displayMessage(String message)
	{
		System.out.println("Hello there " +message );
		
	}
}


