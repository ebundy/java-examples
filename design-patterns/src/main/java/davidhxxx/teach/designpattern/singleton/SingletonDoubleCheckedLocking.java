package davidhxxx.teach.designpattern.singleton;

//Broken multithreaded version before JDK 1.5
public class SingletonDoubleCheckedLocking {

    private static SingletonDoubleCheckedLocking instance;

    private SingletonDoubleCheckedLocking(){
    }
    
    public static SingletonDoubleCheckedLocking getInstance() {
	if (instance == null) {
	    synchronized (SingletonDoubleCheckedLocking.class) {
		if (instance == null)
		    instance = new SingletonDoubleCheckedLocking();
	    }
	}
	
	return instance;
    }
}
