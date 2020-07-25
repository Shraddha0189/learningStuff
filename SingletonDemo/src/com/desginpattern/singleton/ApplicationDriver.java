package com.desginpattern.singleton;


public class ApplicationDriver {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Let us assume that this api is getting called from different class. 
		  So by cliche practice we will instantiate object of this class in each class
		  so as to call this method of the class 
		*/
		
		//let us call this displayMessage api from class1 as:
		/*
		Singleton fromClass1 = new Singleton();
		fromClass1.displayMessage("Class1");
		
		//let us assume that we called this displayMessage api from class2 as:
		Singleton fromClass2 = new Singleton();
		fromClass2.displayMessage("Class2");
		*/
		
		/*So in the above implementation we see that the object is created twice 
		 for just using this common api of displayMessage which is unnecessary..
		 So we can restrict this and re use the created instance by making
		  it a singleton class
		*/
		
		
		Singleton fromClass1 = Singleton.getInstance();
		fromClass1.displayMessage("Class1");
		
		//let us assume that we called this displayMessage api from class2 as:
		Singleton fromClass2 =  Singleton.getInstance();
		fromClass2.displayMessage("Class2");
		
		
		/*as you can see the counter value is 1 and has not increased .
		this indicates that only one instance of the class has been created*/
		
	}

}
