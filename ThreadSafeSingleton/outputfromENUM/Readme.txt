We can use "synchronized" keyword to make this class thread safe, but the problem here is we dont need to use synchronize the class everytime. It is needed only for first few threads
Also calling synchronize is very costly as it can increase the execution time. So to overcome this problem we can use "synchronize blocks"
Istead of applying synchronize keyword on class we will apply this on a particular block where instance is created.


case 1: synchroize on class
	
	*synchroize on class*/
	public static synchronized Singleton getInstance()
	{
		if(instance == null)
			instance = new Singleton();
		
		return instance;
	}

	
case 2: synchroize a block. This is also know as "Double check lockign pattern"
	
	*synchroize on block*/
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
	
But again, even if we have made this thread safe, there is chance that this variable becomes volatile. Now what is a volatie variable?  
class Test  
{  
static int var=5;  
}  

In the above example, assume that two threads are working on the same class. Both threads run on different processors where each thread has its local copy of var.
If any thread modifies its value,the change will not reflect in the original one in the main memory.
It leads to data inconsistency because the other thread is not aware of the modified value.

class Test  
{  
static volatile int var =5;  
}  

In the above example, static variables are class members that are shared among all objects. 
There is only one copy in the main memory.
The value of a volatile variable will never be stored in the cache.All read and write will be done from and to the main memory.


case 3: Using volatile modifier for variable

private static volatile Singleton instance=null;



case 4: Using enum

public enum EasySingleton{
    INSTANCE;
}