package com.desginpattern.singleton;

import com.desginpattern.singleton.EasySingleton.EasySingletonENUM;

/* Implementing thread safe Signelton class
 * First lets see how it works when multiple threads access it
 * created by ssh32
 */
public class ApplicationDriver {

	/**
	 * created by ssh32
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Instead of calling this getInstance sequential lets
		call it in parallel*/
		
		/*
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Singleton fromClass1 = Singleton.getInstance();
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Singleton fromClass2 = Singleton.getInstance();
			}
		});
		
		t1.start();
		t2.start();
		*/
		
		
		
		EasySingletonENUM object1 = EasySingletonENUM.INSTACNE;
		object1.i=5;
		object1.displayMessage();
		
		EasySingletonENUM object2 = EasySingletonENUM.INSTACNE;
		object1.i=6;
		object1.displayMessage();
		
		
		/*if this display message shows different values for i i.e 5 and 6 that means only one
		 * instance is created ..of output is 5 and 5 that means 2 instances are created
		 */
		
	}

}
